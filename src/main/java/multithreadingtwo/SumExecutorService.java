package multithreadingtwo;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import multithreadingtwo.exceptions.MultithreadingException;
import org.apache.commons.collections4.ListUtils;

public class SumExecutorService {
    private static final int THREAD_COUNT = 8;
    private final List<Integer> integerList;

    public SumExecutorService(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public Long getSumOfList() {
        List<List<Integer>> subList = ListUtils.partition(
                integerList, integerList.size() / THREAD_COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<SumCalculatorCallable> sumCalculatorCallables = subList.stream()
                .map(SumCalculatorCallable::new)
                .collect(Collectors.toList());
        try {
            executorService.invokeAll(sumCalculatorCallables);
        } catch (InterruptedException e) {
            throw new MultithreadingException("Can't invoke treads.", e);
        }
        return sumCalculatorCallables.stream()
                .mapToLong(x -> {
                    try {
                        return executorService.submit(x).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new MultithreadingException("Can't sum data from Threads.", e);
                    }
                }).reduce(Long::sum).getAsLong();
    }
}
