package JavaFileHandling;

// Use the FileWriter class in append mode.

import java.io.FileWriter;
import java.io.IOException;

public class FileAppend {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt", true);
            writer.write("\nThis text is appended.");
            System.out.println("Text appended successfully.");
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
