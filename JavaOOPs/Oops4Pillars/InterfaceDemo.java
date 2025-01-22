package JavaOOPs.Oops4Pillars;

// An interface in Java is a completely abstract type that specifies a set of methods that a class must implement.

// Interface for flying behavior
interface Flyable {
    void fly(); // Abstract method by default
}

// Interface for swimming behavior
interface Swimmable {
    void swim(); // Abstract method
}

// Concrete class implementing multiple interfaces
class Bird implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Bird is flying,");
    }

    @Override
    public void swim() {
        System.out.println("Bird is swimming.");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.swim();
    }
}
