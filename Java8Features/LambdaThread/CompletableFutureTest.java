package Java8Features.LambdaThread;

import java.util.concurrent.CompletableFuture;

// 6️⃣ CompletableFuture (Async Programming)
// For asynchronous task execution, CompletableFuture is more powerful than Future.
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Void> orderProcess = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Order is being prepared...");
                Thread.sleep(2000);
                System.out.println("Order is ready!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        orderProcess.thenRun(() -> System.out.println("Delivery started..."));
        orderProcess.join();
    }
}
