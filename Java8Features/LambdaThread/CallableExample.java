package Java8Features.LambdaThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Callable and Future (Returning Results from Threads)
public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            int totalTime = 0;
            for (int i = 1; i <= 5; i++) {
                System.out.println("Chef is preparing order #" + i);
                Thread.sleep(1000);
                totalTime += 1000;
            }
            return totalTime;
        };

        Future<Integer> result = executorService.submit(task); // Excute Callable Task

        try {
            System.out.println("Total preparation time: " + result.get() + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
