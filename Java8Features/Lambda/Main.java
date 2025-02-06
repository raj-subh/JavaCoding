package Java8Features.Lambda;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programm Started...");

        // Implement implement = new Implement();
        // MyInterface interface1 = new Implement();

        // implement.sayHello();
        // interface1.sayHello();

        // Anonymous class
        MyInterface interface1 = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hi from anonymous class");
            }
        };
        interface1.sayHello();

        MyInterface interface2 = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hi from second anonymous class.");
            }
        };
        interface2.sayHello();

        // functionalInterface using lambda expression
        MyInterface interface3 = () -> {
            System.out.println("This is my first time to using lambda expression.");
        };
        interface3.sayHello();

        MyInterface interface4 = () -> {
            System.out.println("This is second time, I am using lambda expression in our code.");
        };
        interface4.sayHello();
    }
}
