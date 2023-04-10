package task4.sorts;

import java.util.Comparator;

public interface MySort<T> {
    void sort(Comparator<? super T> comparator);
}
