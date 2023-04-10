package task1;

import java.util.Comparator;

public class SecondComparator implements Comparator<String> {
    private int compareCounter;
    private final String startSubstring;
    private final String endSubstring;

    public SecondComparator(String startSubstring, String endSubstring) {
        compareCounter = 0;
        this.startSubstring = startSubstring;
        this.endSubstring = endSubstring;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    @Override
    public int compare(String s1, String s2) {
        compareCounter++;

        int index1 = s1.indexOf(startSubstring);
        int index2 = s1.lastIndexOf(endSubstring);
        if (index1 == -1 || index2 == -1 || index1 > index2) {
            return 1;
        }
        s1 = s1.substring(index1, index2);

        index1 = s2.indexOf(startSubstring) + startSubstring.length();
        index2 = s2.lastIndexOf(endSubstring);
        if (index1 == -1 || index2 == -1 || index1 > index2) {
            return -1;
        }
        s2 = s2.substring(index1, index2);

        return s1.compareToIgnoreCase(s2);
    }
}
