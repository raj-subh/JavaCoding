package JavaThread;

// Producer thread class
class Producer extends Thread {
    private final MultiThreading obj;

    Producer(MultiThreading multiThreading) {
        this.obj = multiThreading;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            this.obj.produceItem(i);
            try {
                Thread.sleep(1000); // Simulate delay for producing an item
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
            i++;
        }
    }
}

// Consumer thread class
class Consumer extends Thread {
    private final MultiThreading obj;

    Consumer(MultiThreading multiThreading) {
        this.obj = multiThreading;
    }

    @Override
    public void run() {
        while (true) {
            this.obj.consumeItem();
            try {
                Thread.sleep(1000); // Simulate delay for consuming an item
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
        }
    }
}

// Shared resource class
public class MultiThreading {
    private int n; // Shared variable
    private boolean flag = false; // To synchronize producer and consumer

    // Method for producing an item
    public synchronized void produceItem(int n) {
        while (flag) { // Wait if an item is already produced
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Producer wait interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
        }
        this.n = n;
        System.out.println("Produced: " + this.n);
        flag = true; // Item produced, consumer can now consume
        notify(); // Notify the consumer
    }

    // Method for consuming an item
    public synchronized void consumeItem() {
        while (!flag) { // Wait if no item is produced
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Consumer wait interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
        }
        System.out.println("Consumed: " + this.n);
        flag = false; // Item consumed, producer can now produce
        notify(); // Notify the producer
    }

    // Main method
    public static void main(String[] args) {
        MultiThreading sharedResource = new MultiThreading();

        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        producer.start(); // Start producer thread
        consumer.start(); // Start consumer thread
    }
}