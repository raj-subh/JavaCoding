package Java8Features.LambdaThread;
// 3️⃣ Thread Pooling with ExecutorService Instead of creating a new thread every time (which is inefficient), use thread pools to manage resources efficiently.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 3 delivery Persons

        for (int i = 1; i <= 5; i++) {
            final int orderNum = i;
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is delivering order #" + orderNum);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " has delivered order #" + orderNum);
            });
        }
        executorService.shutdown(); // Shutdown after all tasks are done
    }
}
