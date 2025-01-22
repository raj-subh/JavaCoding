package JavaOOPs.JavaSingleton;

// A Thread-Safe Singleton ensures that the Singleton instance is safely created even in multi-threaded environments. This is achieved using synchronization.

class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    // Private constructor
    private ThreadSafeSingleton() {
        System.out.println("ThreadSafeSingleton Instance Created!");
    }

    // Synchronized method to ensure thread safety
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

public class ThreadSafe {
    public static void main(String[] args) {
        ThreadSafeSingleton obj1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton obj2 = ThreadSafeSingleton.getInstance();

        System.out.println("Are obj2 and obj1 the same? " + (obj1 == obj2));
    }
}
