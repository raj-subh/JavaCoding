package JavaFileHandling;

// Using BufferedReader and BufferedWriter These classes are more efficient for reading/writing large amounts of data.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteBuffered {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("example.txt"))) {
            bw.write("BufferedWriter is efficient for large data.");
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
