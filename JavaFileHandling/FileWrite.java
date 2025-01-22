package JavaFileHandling;

import java.io.FileWriter;
import java.io.IOException;

// Use the FileWriter class to write text into a file.

public class FileWrite {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, this is a sample text file!");
            writer.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
