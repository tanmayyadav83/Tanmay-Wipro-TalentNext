class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Count: " + i);
        }
        System.out.println(getName() + " completed.");
    }
}

public class a4 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-MAX");
        MyThread t2 = new MyThread("Thread-MIN");
        MyThread t3 = new MyThread("Thread-NORM");

        t1.setPriority(Thread.MAX_PRIORITY);   // 10
        t2.setPriority(Thread.MIN_PRIORITY);   // 1
        t3.setPriority(Thread.NORM_PRIORITY);  // 5

        t1.start();
    }
}
