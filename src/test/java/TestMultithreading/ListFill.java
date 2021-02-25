package TestMultithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface ListFill {
    int COUNT_MAX_ELEMENTS = 1_000_000;

    default List<Integer> fillZeroList() {
        return IntStream.range(0, COUNT_MAX_ELEMENTS)
                .map(x -> 0)
                .boxed()
                .collect(Collectors.toList());
    }

    default List<Integer> fillWithOne() {
        return IntStream.range(0, COUNT_MAX_ELEMENTS)
                .map(x -> 1)
                .boxed()
                .collect(Collectors.toList());
    }

    default List<Integer> fillWithNegativeNumbers() {
        return IntStream.range(0, COUNT_MAX_ELEMENTS)
                .map(x -> -1)
                .boxed()
                .collect(Collectors.toList());
    }
}
