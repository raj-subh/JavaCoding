package JavaException;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FinallyBlock {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("example.txt");
            // perform file operations

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());

        } finally {
            if (fis != null) {
                try {
                    fis.close();

                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }
}
