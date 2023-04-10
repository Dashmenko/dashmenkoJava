import java.util.Comparator;

public class Count implements Comparator<String> //компаратор по количеству вхождений
{
    private final String abc;
    public int kol = 0;
    public  long counter=0;
    public long getCounter() {
        return counter;
    }
    Count(String abc)
    {
        this.abc=abc;
    }

    int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    @Override
    public int compare(String o1, String o2) {
        counter++;
        return count(o1,abc)-count(o2,abc);
    }
}