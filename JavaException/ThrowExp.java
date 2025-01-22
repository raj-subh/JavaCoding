package JavaException;

public class ThrowExp {
    public static void main(String[] args) {
        int balance = 5000;
        int withrawalAmt = 4000;

        try {
            if (balance < withrawalAmt) {
                throw new ArithmeticException("Insufficient balance");
            }

            balance = balance - withrawalAmt;
            System.out.println("Transaction Successfully Completed");

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Program Continue...");
    }
}
