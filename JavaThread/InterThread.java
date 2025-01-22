package JavaThread;

// Inter-Thread Communication: Threads can communicate with each other using methods like wait(), notify(), and notifyAll().
class SharedResource {
    private boolean isAvailable = false;

    public synchronized void produce() {
        try {
            while (isAvailable) {
                wait(); // Wait if resource is already available
            }
            System.out.println("Producing resource...");
            isAvailable = true;
            notify(); // Notify the consumer

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume() {
        try {
            while (!isAvailable) {
                wait(); // Wait if no resource is available
            }
            System.out.println("Consuming resource...");
            isAvailable = false;
            notify(); // Notify the producer

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class InterThread {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(resource::produce);
        Thread consumer = new Thread(resource::consume);

        producer.start();
        consumer.start();
    }
}
