package Views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelComePage {
    public static void welcomeScreen() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the app..");
        System.out.println("Press 0 to exit...");
        System.out.println("Press 1 to Login: ");
        System.out.println("Press 2 to SignUp: ");

        int choice = 0;
        try {
            choice = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice) {
            case 0 -> System.exit(0);

            case 1 -> loginPage();

            case 2 -> signUpPage();

            default -> System.out.println("Invalid Input..");
        }
    }

    private static void loginPage() {

    }

    private static void signUpPage() {

    }
}
