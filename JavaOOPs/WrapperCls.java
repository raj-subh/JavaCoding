package JavaOOPs;

// Java provides Wrapper Classes for primitive data types to allow them to be treated as objects (e.g., int -> Integer, double -> Double).

public class WrapperCls {
    public static void main(String[] args) {
        // Primitive to wrapper (Autoboxing)
        int num = 10;
        Integer numWrapper = num; // Autoboxing
        System.out.println("Primitive to Wrapper: " + numWrapper);

        // Wrapper to Primitive (Unboxing)
        Integer obj = Integer.valueOf(20);
        int primitiveNum = obj; // Unboxing
        System.out.println("Wrapper to Primitive: " + primitiveNum);

        // Utility methods
        String strNum = "123";
        int parsedNum = Integer.parseInt(strNum); // Convert string to int
        System.out.println("Parsed Number: " + parsedNum);

        // Auto comparison
        Integer num1 = 100;
        Integer num2 = 100;
        System.out.println("Are num1 and num2 the same? " + (num1 == num2)); // Auto-boxing cache effect for small
                                                                             // integers
    }
}
