package Java8Features.Lambda01;

public class MainMethod {
    public static void main(String[] args) {
        SumInterface sumInterface = (int num1, int num2) -> {
            return num1 + num2;
        };
        System.out.println(sumInterface.sum(5, 5));
        System.out.println(sumInterface.sum(10, 20));

        Multiplication multiplication = (num1, num2) -> num1 * num2;
        System.out.println(multiplication.multiplication(10, 10));
        System.out.println(multiplication.multiplication(12.2, 13.2));

        StringInterface strInterface = (str) -> str.length();
        System.out.println(strInterface.getLengthStr("Raj Ankita"));
    }
}
