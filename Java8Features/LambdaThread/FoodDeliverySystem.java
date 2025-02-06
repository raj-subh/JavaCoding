package Java8Features.LambdaThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        // Shared queue to store prepared orders
        BlockingQueue<Integer> orderQueue = new LinkedBlockingQueue<>();

        // Chef (Thread-1): Preparing food
        Thread chef = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println("Chef is preparing order #" + i);
                    Thread.sleep(1000); // SImulating cooking time
                    orderQueue.put(i); // Add prepared order to the queue
                    System.out.println("Order #" + i + " is ready for delivery!");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("All orders are prepared!");
        });

        // Delivery Person (Thread-2): Delivering food
        Thread deliveryPerson = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    int order = orderQueue.take(); // Waits until an order is available
                    System.out.println("Delivery person is delivering order #" + order);
                    Thread.sleep(1500); // Simulating delivery time

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("All the orders have been delivered!");
        });

        // Start both threads
        chef.start();
        deliveryPerson.start();
    }
}
