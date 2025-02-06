package Java8Features.LambdaThread;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Program Started...");

        // first thread
        Runnable thread1 = () -> {
            // this is the body of thread
            for (int i = 1; i <= 20; i++) {
                System.out.println("Value of i is: " + i);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(thread1);
        thread.setName("John");
        thread.start();

        // second thread
        Runnable thread2 = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i * 2);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread3 = new Thread(thread2);
        thread3.start();
    }
}
