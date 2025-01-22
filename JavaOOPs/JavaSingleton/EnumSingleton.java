package JavaOOPs.JavaSingleton;

// An Enum Singleton leverages the enum type to provide a Singleton instance. It is inherently thread-safe and provides serialization guarantees.

enum EnumSingletonDemo {
    INSTANCE;

    public void displayMessage() {
        System.out.println("Hello from Enum Singleton!");
    }
}

public class EnumSingleton {
    public static void main(String[] args) {
        EnumSingletonDemo obj1 = EnumSingletonDemo.INSTANCE;
        EnumSingletonDemo obj2 = EnumSingletonDemo.INSTANCE;

        obj1.displayMessage();
        System.out.println("Are obj1 and obj2 the same? " + (obj1 == obj2));
    }
}
