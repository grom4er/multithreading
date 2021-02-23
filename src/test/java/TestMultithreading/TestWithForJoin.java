package TestMultithreading;
import multithreadingtwo.SumWithForJoin;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestWithForJoin implements ListFill{
    private static SumWithForJoin executorService;

    @Test
    public void getSumWithZeroArray() {
        executorService = new SumWithForJoin(fillZeroList());
        assertEquals(Long.valueOf(0), executorService.getSumOfList());
    }
    @Test
    public void getSumWithAllOneArray() {
        executorService = new SumWithForJoin(fillWithOne());
        assertEquals(Long.valueOf(1_000_000), executorService.getSumOfList());
    }
    @Test
    public void getSumWithAllNegativeOneArray() {
        executorService = new SumWithForJoin(fillWithNegativeNumbers());
        assertEquals(Long.valueOf(-1_000_000), executorService.getSumOfList());
    }
}
