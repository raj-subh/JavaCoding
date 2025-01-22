package JavaThread;

// A Thread is a lightweight process and the smallest unit of a program that can execute independently.
// In Java, threads enable multitasking by allowing multiple parts of a program to run concurrently.
// Concurrency: Perform multiple tasks simultaneously.
// Improved Performance: Utilizes multi-core processors effectively.
// Responsiveness: Keeps applications responsive, such as in GUI or web servers.

class FileDownloadThread extends Thread {
    // Code: Extending the Thread Class
    private String fileName;

    public FileDownloadThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Downloading " + fileName + "...");
        try {
            Thread.sleep(2000); // Simulate download time

        } catch (InterruptedException e) {
            System.out.println("Download interrupted for " + fileName);
        }
        System.out.println("Downloaded " + fileName);
    }
}

public class ThreadClass {
    public static void main(String[] args) {

        FileDownloadThread thread1 = new FileDownloadThread("FIle1.pdf");
        FileDownloadThread thread2 = new FileDownloadThread("File2.mp4");

        thread1.start(); // Start thead 1
        thread2.start(); // Start thread 2
    }
}
