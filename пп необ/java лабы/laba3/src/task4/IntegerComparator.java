package task4;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
    private int compareCounter;

    public IntegerComparator() {
        compareCounter = 0;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        compareCounter++;
        return Integer.compare(o1, o2);
    }
}
