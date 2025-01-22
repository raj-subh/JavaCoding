package JavaThread;

// Thread Synchronization: When multiple threads share a common resource, it can lead to race conditions. Synchronization ensures that only one thread accesses the resource at a time.

// Scenario: Bank Account Withdrawal
class BankAccount {
    private double balance = 1000;

    public synchronized void withraw(double amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withrawing ₹" + amount);
            balance -= amount;
            System.out.println("Remaining balance: ₹" + balance);

        } else {
            System.out.println("insufficient balance for " + Thread.currentThread().getName());
        }
    }
}

public class Synchronization {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread user1 = new Thread(() -> account.withraw(700), "User1");
        Thread user2 = new Thread(() -> account.withraw(500), "User2");

        user1.start();
        user2.start();
    }
}
