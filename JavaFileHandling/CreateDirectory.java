package JavaFileHandling;

// Working with Directories Use File to create or delete directories.

import java.io.File;

public class CreateDirectory {
    public static void main(String[] args) {
        File directory = new File("MyDirectory");
        if (directory.mkdir()) {
            System.out.println("Directory created: " + directory.getName());

        } else {
            System.out.println("Directory already exists or failed to created.");
        }

    }
}
