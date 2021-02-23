package multithreadingtwo;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class SumWithForJoin {
    private static final int THREAD_COUNT = 8;
    private List<Integer> integerList;

    public SumWithForJoin(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public Long getSumOfList() {
        List<List<Integer>> subList = ListUtils.partition(
                integerList, integerList.size() / THREAD_COUNT);
        List<RecursiveThread> recursiveThreads = subList.stream()
                .map(RecursiveThread::new)
                .collect(Collectors.toList());
        Collection<RecursiveThread> invokedThreads = ForkJoinTask.invokeAll(recursiveThreads);
        return invokedThreads.stream()
                .mapToLong(ForkJoinTask::join)
                .reduce(0, Long::sum);
    }
}
