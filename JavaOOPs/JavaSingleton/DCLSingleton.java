package JavaOOPs.JavaSingleton;

// Double-Checked Locking Singleton: This is an optimized version of the Thread-Safe Singleton. It reduces the overhead of synchronized blocks by checking the instance twice. Better performance compared to Thread-Safe Singleton.

class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    // Private constructor
    private DoubleCheckedLockingSingleton() {
        System.out.println("DoubleCheckedLockingSingleton Instance Created!");
    }

    // Method to get the instance with double-checked locking
    public static DoubleCheckedLockingSingleton getInstace() {
        if (instance == null) { // first check
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // second check
                    instance = new DoubleCheckedLockingSingleton();

                }
            }
        }
        return instance;
    }
}

public class DCLSingleton {
    public static void main(String[] args) {
        DoubleCheckedLockingSingleton obj1 = DoubleCheckedLockingSingleton.getInstace();
        DoubleCheckedLockingSingleton obj2 = DoubleCheckedLockingSingleton.getInstace();

        System.out.println("Are obj1 and obj2 the same? " + (obj1 == obj2));
    }
}
