package JavaFileHandling;

// Copy files efficiently using the Files class from java.nio.file.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopy {
    public static void main(String[] args) {
        Path source = Paths.get("example.txt");
        Path destination = Paths.get("copy_example.txt");

        try {
            Files.copy(source, destination);
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
