package JavaThread;

// Thread Pooling: Managing multiple threads can be resource-intensive. Thread pools manage a fixed number of threads, reusing them for multiple tasks.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executorService.execute(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
