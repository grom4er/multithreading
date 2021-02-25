package TestMultithreading;
import static org.junit.Assert.*;

import multithreadingtwo.SumExecutorService;
import org.junit.Test;


public class TestExecutorService implements ListFill {
    private static SumExecutorService executorService;

    @Test
    public void getSumWithZeroArray() {
        executorService = new SumExecutorService(fillZeroList());
        assertEquals(Long.valueOf(0), executorService.getSumOfList());
    }
    @Test
    public void getSumWithAllOneArray() {
        executorService = new SumExecutorService(fillWithOne());
        assertEquals(Long.valueOf(1_000_000), executorService.getSumOfList());
    }
    @Test
    public void getSumWithAllNegativeOneArray() {
        executorService = new SumExecutorService(fillWithNegativeNumbers());
        assertEquals(Long.valueOf(-1_000_000), executorService.getSumOfList());
    }
}
