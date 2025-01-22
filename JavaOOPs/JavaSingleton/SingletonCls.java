package JavaOOPs.JavaSingleton;

// A Singleton Class ensures that only one instance of the class is created during the application's lifecycle. It is useful for scenarios like database connections or logging. 
// Key Features:
// Private constructor: Prevents external instantiation.
// Static method: Provides a global access point to the instance.
// Static variable: Holds the single instance.

class Singleton {
    // static variable to hold the single instance
    private static Singleton instance;

    // private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton Intance Created!");
    }

    // static method to provide global access to the instance
    public static Singleton getInstance() {
        if (instance == null) { // Lazy initialization
            instance = new Singleton();
        }
        return instance;
    }

    // Example method
    public void displayMessage() {
        System.out.println("Hello from Singleton Class!");
    }
}

public class SingletonCls {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        obj1.displayMessage();

        // check if both instances are the same
        System.out.println("Are obj1 and obj2 the same? " + (obj1 == obj2));
    }
}
