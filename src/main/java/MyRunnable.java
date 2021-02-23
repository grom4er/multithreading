import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        logger.info("MyRunnable thread started:" + System.lineSeparator());
        for (int i = 0; i < 100; i++) {
            logger.info(Thread.currentThread().getName() + " value = "
                    + counter.getValue() + System.lineSeparator());
            counter.increment();
        }
        logger.info("MyRunnable finished." + System.lineSeparator());
    }
}
