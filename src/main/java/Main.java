public class Main {
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread myThread = new MyThread(counter, MAX_VALUE);
        MyRunnable myRunnable = new MyRunnable(counter, MAX_VALUE);
        myThread.start();
        new Thread(myRunnable).start();
    }
}
