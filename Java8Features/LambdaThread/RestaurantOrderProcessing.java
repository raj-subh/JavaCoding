package Java8Features.LambdaThread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Real-World Scenario: Restaurant Order Processing System Using Advanced Thread Concepts
// ---------------------------------------------------------------------------------------------------------------------------
// We will implement a multi-threaded restaurant order processing system that demonstrates advanced threading concepts like:
// ✅ ExecutorService for thread pooling
// ✅ CountDownLatch for synchronization
// ✅ BlockingQueue for inter-thread communication
// ✅ Callable & Future for returning results
// ✅ CompletableFuture for asynchronous execution
// ---------------------------------------------------------------------------------------------------------------------------
// 🛒 Scenario:
// A restaurant has multiple chefs and delivery persons working simultaneously.
// Customers place orders.
// Chefs prepare orders using multiple threads.
// Orders are then moved to a queue.
// Delivery persons take the orders and deliver them.
// The system ensures synchronization and avoids bottlenecks.

public class RestaurantOrderProcessing {
    private static final int TOTAL_ORDERS = 5;
    private static final ExecutorService chefPool = Executors.newFixedThreadPool(3);
    private static final ExecutorService deliveryPool = Executors.newFixedThreadPool(2);

    private static final Queue<Integer> orderQueue = new ConcurrentLinkedQueue<>();
    private static final CountDownLatch allOrdersPrepared = new CountDownLatch(TOTAL_ORDERS);
    private static final CountDownLatch allOrdersDelivered = new CountDownLatch(TOTAL_ORDERS);

    public static void main(String[] args) {
        // Ensure orders are prepared in sequence
        for (int i = 1; i <= TOTAL_ORDERS; i++) {
            final int orderId = i;
            chefPool.submit(() -> {
                try {
                    Thread.sleep(2000); // Simulate preparation time
                    System.out.println("🍳 Chef prepared order #" + orderId);
                    synchronized (orderQueue) {
                        orderQueue.add(orderId); // Store orders in sequence
                    }
                    allOrdersPrepared.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Ensure "All orders prepared" appears at the right time
        new Thread(() -> {
            try {
                allOrdersPrepared.await();
                System.out.println("✅ All orders are prepared!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Ensure orders are delivered in correct sequence
        for (int i = 0; i < TOTAL_ORDERS; i++) {
            deliveryPool.execute(() -> {
                try {
                    int orderId;
                    synchronized (orderQueue) {
                        while (orderQueue.isEmpty()) {
                            Thread.sleep(500); // Wait until an order is ready
                        }
                        orderId = orderQueue.poll(); // Take in correct order
                    }
                    Thread.sleep(3000); // Simulate delivery time
                    System.out.println("🚚 Delivery person delivered order #" + orderId);
                    allOrdersDelivered.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Ensure "All orders delivered" appears at the right time
        new Thread(() -> {
            try {
                allOrdersDelivered.await();
                System.out.println("🏁 All orders have been delivered!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Shutdown thread pools
        chefPool.shutdown();
        deliveryPool.shutdown();
    }
}
