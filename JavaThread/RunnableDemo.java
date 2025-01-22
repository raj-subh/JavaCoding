package JavaThread;

// Code: Implementing the Runnable Interface
class FileDownloadTask implements Runnable {
    private String fileName;

    public FileDownloadTask(String fileName) {
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

public class RunnableDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new FileDownloadTask("File1.pdf"));
        Thread thread2 = new Thread(new FileDownloadTask("File2.mp4"));

        thread1.start();
        thread2.start();
    }
}