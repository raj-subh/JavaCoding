package JavaOOPs.JavaSingleton;

// In Eager Initialization, the instance of the Singleton class is created at the time of class loading. This is the simplest implementation. Might lead to resource wastage if the instance is never used.

class EagerSingletonDemo {
    // Instance is created when the class is loaded
    private static final EagerSingletonDemo instance = new EagerSingletonDemo();

    // Private constructor
    private EagerSingletonDemo() {
        System.out.println("EagerSingletonDemo Instance Created!");
    }

    // Public method to provide access to the instance
    public static EagerSingletonDemo getInstance() {
        return instance;
    }
}

public class EagerSingleton {
    public static void main(String[] args) {
        EagerSingletonDemo obj1 = EagerSingletonDemo.getInstance();
        EagerSingletonDemo obj2 = EagerSingletonDemo.getInstance();

        System.out.println("Are obj1 and obj2 the same? " + (obj1 == obj2));

    }
}
