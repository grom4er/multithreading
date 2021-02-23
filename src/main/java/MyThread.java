import org.apache.log4j.Logger;

public class MyThread extends Thread {
    private static final Logger logger = Logger.getLogger(MyThread.class);
    private Counter counter;
    int maxValue;

    public MyThread(Counter counter, int maxValue) {
        this.counter = counter;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        logger.info("MyThread thread started:" + System.lineSeparator());
        while (counter.getValue() < maxValue) {
            logger.info(Thread.currentThread().getName() + " value = "
                    + counter.getValue() + System.lineSeparator());
            counter.increment();
        }
        logger.info("MyThread finished." + System.lineSeparator());
    }
}
