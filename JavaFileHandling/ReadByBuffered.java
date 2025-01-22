package JavaFileHandling;

// Using BufferedReader and BufferedWriter These classes are more efficient for reading/writing large amounts of data.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadByBuffered {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // Using try-with-resources for efficient resource management
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print each line
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
