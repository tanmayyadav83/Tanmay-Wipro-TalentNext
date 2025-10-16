public class a3 implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (i == 5) {
                try {
                    Thread.sleep(5000); // Delay for 5 seconds
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new a3());
        t.start();
    }
}
