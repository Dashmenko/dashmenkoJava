package task4.sorts;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSort<T> implements MySort<T> {
    private int swapCounter;
    private int compareCounter;
    private final T[] arr;

    public BubbleSort(T[] arr) {
        this.arr = arr;
    }

    public int getSwapCounter() {
        return swapCounter;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    public T[] getArr() {
        return arr;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int j = 1; j < arr.length; ++j) {
                if (comparator.compare(arr[j - 1], arr[j]) > 0) {
                    compareCounter++;
                    isSorted = false;

                    T buf = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = buf;
                    swapCounter++;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
