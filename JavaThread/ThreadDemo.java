package JavaThread;

class A implements Runnable {
    public void run() {
        int i;
        for (i = 0; i <= 20; i++) {
            System.out.println("Thread A " + i);
        }
    }
}

class B implements Runnable {
    public void run() {
        int i;
        for (i = 0; i <= 10; i++) {
            System.out.println("Thread B " + i);
        }
    }
}

class C implements Runnable {
    public void run() {
        int i;
        for (i = 0; i <= 10; i++) {
            System.out.println("Thread C " + i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new A());
        Thread thread2 = new Thread(new B());
        Thread thread3 = new Thread(new C());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
