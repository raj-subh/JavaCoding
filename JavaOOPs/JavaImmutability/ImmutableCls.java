package JavaOOPs.JavaImmutability;

// An Immutable Class is one whose objects cannot be modified after creation. It is useful for creating read-only objects like String. Private final fields: Prevent modification of data. No setters: Data cannot be changed after initialization. Final class: Prevent inheritance (optional).

final class ImmutableClassDemo {
    private final String name;
    private final int age;

    // Constructor to initialize fields
    public ImmutableClassDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters to access fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

public class ImmutableCls {
    public static void main(String[] args) {
        ImmutableClassDemo obj = new ImmutableClassDemo("Ankita", 25);

        // Access values
        System.out.println("Name: " + obj.getName());

        System.out.println("Age: " + obj.getAge());

        // No way to modify the object (no setters provided)
    }
}
