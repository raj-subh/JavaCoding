package Java8Features.LambdaThread;

import java.util.concurrent.CountDownLatch;

// ✅ CountDownLatch (Wait for multiple tasks to complete)
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5); // 5 orders to prepare

        // Chef Thread
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Chef is preparing order #" + i);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown(); // Decrease count
            }
        }).start();

        // Delivery Person Thread
        new Thread(() -> {
            try {
                latch.await(); // Wait for all orders to be ready
                System.out.println("All orders are ready! Delivery started.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
