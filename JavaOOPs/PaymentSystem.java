package JavaOOPs;

// Interface: Define the contract for payment methods
interface PaymentGateway {
    void pay(double amount); // Abstract method for payment

    void refund(double amount); // Abstract method for refund
}

// Abstract Class: Provides common implementation and structure for payment
// methods
abstract class Payment {
    private String paymentId;

    public Payment(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void printReciept() {
        System.out.println("Receipt generated for Payment ID: " + paymentId);
    }

    // Abstract method to be implemented by specific payment types
    public abstract void processPayment(double amount);
}

// Concrete Class 1: Implements the PaymentGateway and extends Payment for
// Credit Card
class CreditCardPayment extends Payment implements PaymentGateway {
    private double creditLimit;

    public CreditCardPayment(String paymentId, double creditLimit) {
        super(paymentId);
        this.creditLimit = creditLimit;
    }

    @Override
    public void pay(double amount) {
        if (amount > creditLimit) {
            System.out.println("Payment failed. Exceeds credit limit.");

        } else {
            System.out.println("Payment of ₹" + amount + " processed via Credit Card.");
            creditLimit -= amount;
        }
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed back to Credit Card.");
        creditLimit += amount;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment...");
        pay(amount);
    }
}

// Concrete Class 2: Implements the PaymentGateway and extends Payment for UPI
class UpiPayment extends Payment implements PaymentGateway {
    private String upiId;

    public UpiPayment(String paymentId, String upiId) {
        super(paymentId);
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " processed via UPI (" + upiId + ").");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed back to UPI (" + upiId + ").");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment...");
        pay(amount);
    }
}

// Main Class: Demonstrates the use of Abstract Class and Interface
public class PaymentSystem {
    public static void main(String[] args) {
        // Credit Card Payment
        Payment creditCardPayment = new CreditCardPayment("CC12345", 50000);
        creditCardPayment.processPayment(3000); // Process payment amount via Credit Card
        creditCardPayment.printReciept(); // Common method from Abstract Class
        ((CreditCardPayment) creditCardPayment).refund(1000); // Refund

        System.out.println();

        // UPI Payment
        Payment upiPayment = new UpiPayment("UPI67890", "user@upi");
        upiPayment.processPayment(1500); // Process payment via UPI
        upiPayment.printReciept(); // Common method from Abstract Class
        ((UpiPayment) upiPayment).refund(500); // Refund
    }
}
