package task4.sorts;

import java.util.Arrays;
import java.util.Comparator;

public class GnomeSort<T> implements MySort<T> {
    private int swapCounter;
    private int compareCounter;
    private final T[] arr;

    public GnomeSort(T[] arr) {
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
        int i = 1;
        int j = 2;
        while (i < arr.length) {
            if (comparator.compare(arr[i - 1], arr[i]) < 0) {
                compareCounter++;
                i = j;
                j++;
            } else {
                T buf = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = buf;
                swapCounter++;

                i = i - 1;
                if (i == 0) {
                    i = j;
                    j++;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}

