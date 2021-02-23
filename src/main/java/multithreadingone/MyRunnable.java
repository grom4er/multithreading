package multithreadingone;

import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private Counter counter;
    private int maxValue;

    public MyRunnable(Counter counter, int maxValue) {
        this.counter = counter;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        logger.info("multithreading.MyRunnable thread started:" + System.lineSeparator());
        while (counter.getValue() < maxValue) {
            logger.info(Thread.currentThread().getName() + " value = "
                    + counter.getValue() + System.lineSeparator());
            counter.increment();
        }
        logger.info("multithreading.MyRunnable finished." + System.lineSeparator());
    }
}
