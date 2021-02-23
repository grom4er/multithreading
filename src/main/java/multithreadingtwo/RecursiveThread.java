package multithreadingtwo;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveThread extends RecursiveTask<Integer> {
    private List<Integer> list;

    public RecursiveThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        return list.stream().reduce(0, Integer::sum);
    }
}
