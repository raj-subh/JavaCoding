package Java8Features.LambdaThread;

public class ThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running...");
        });

        System.out.println("Thread State: " + thread.getState()); // New
        thread.start();
        System.out.println("Thread State after start(): " + thread.getState()); // RUNNABLE
    }
}
