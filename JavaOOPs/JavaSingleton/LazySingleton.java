package JavaOOPs.JavaSingleton;

// In Lazy Initialization, the Singleton instance is created only when it is accessed for the first time. This avoids unnecessary creation of the instance.

class LazySingletonDemo {
    private static LazySingletonDemo instance;

    // Private constructor
    private LazySingletonDemo() {
        System.out.println("LazySingleton Instance Created!");
    }

    // Public method to provide access to the instance
    public static LazySingletonDemo getInstance() {
        if (instance == null) {
            instance = new LazySingletonDemo();
        }
        return instance;
    }
}

public class LazySingleton {
    public static void main(String[] args) {
        LazySingletonDemo obj1 = LazySingletonDemo.getInstance();
        LazySingletonDemo obj2 = LazySingletonDemo.getInstance();

        System.out.println("Are obj1 and obj2 the same? " + (obj1 == obj2));
    }
}
