package JavaConcurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FetchProductData implements Callable<String> {
    private String apiName;

    public FetchProductData(String apiName) {
        this.apiName = apiName;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is fetching data " + apiName + " ... ");
        // Simulate API call delay
        Thread.sleep(2000);
        return "Data from " + apiName;
    }
}

public class ECommerce {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Define tasks to fetch data from APIs
        Callable<String> task1 = new FetchProductData("API 1");
        Callable<String> task2 = new FetchProductData("API 2");
        Callable<String> task3 = new FetchProductData("API 3");

        try {
            System.out.println("Submitting taks to ExecutorService...");

            // Submit all tasks and get results as a list fo Future objects
            List<Future<String>> futures = executorService.invokeAll(List.of(task1, task2, task3));

            System.out.println("\nProcessing results...");
            for (Future<String> future : futures) {
                // Retrieve results of each task
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            executorService.shutdown();
            System.out.println("\nExecutorService has been shut down.");
        }
    }
}
