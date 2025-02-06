package Java8Features.LambdaThread;

import java.util.concurrent.Semaphore;

// Semaphore (Limits thread access to a resource)
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // Allow only 2 thread at a time

        Runnable task = () -> {
            try {
                semaphore.acquire(); // Get permission
                System.out.println(Thread.currentThread().getName() + " is delivering an order...");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " has finished delivery.");
                semaphore.release(); // Release permission

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Simulating multiple delivery persons
        for (int i = 1; i <= 5; i++) {
            new Thread(task, "Delivery Person " + i).start();
        }
    }
}
