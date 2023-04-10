package task1;

import java.util.Comparator;

public class FirstComparator implements Comparator<String> {
    private int compareCounter;
    private final String substring;

    public FirstComparator(String substring) {
        compareCounter = 0;
        this.substring = substring;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    @Override
    public int compare(String s1, String s2) {
        compareCounter++;

        int n1 = s1.lastIndexOf(substring);
        int n2 = s2.lastIndexOf(substring);

        return (n1 == -1) ? 1 : ((n2 == -1) ? -1 : Integer.compare(n1, n2));
    }
}
