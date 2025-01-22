package JavaOOPs.JavaSingleton;

// This implementation uses a static inner helper class to create the Singleton instance. The instance is created only when the getInstance() method is called.

class BillPughSingleton {
    // Private constructor
    private BillPughSingleton() {
        System.out.println("BillPughSingleton Instance Created!");
    }

    // Static inner class to hold the Singleton instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Public method to provide access to the instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

public class BillPughSgltn {
    public static void main(String[] args) {
        BillPughSingleton obj1 = BillPughSingleton.getInstance();
        BillPughSingleton obj2 = BillPughSingleton.getInstance();

        System.out.println("Are obj1 and obj2 the same? " + (obj1 == obj2));
    }
}
