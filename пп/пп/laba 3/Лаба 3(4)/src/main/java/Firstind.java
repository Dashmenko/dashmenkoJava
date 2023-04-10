import java.util.Comparator;

public class Firstind implements Comparator<String> //компаратор по первому вхождению
{
    private final String s;
    public  long counter=0;
    public long getCounter() {
        return counter;
    }
    public Firstind(String s)
    {
        this.s = s;
    }


    public int kol = 0;


    @Override
    public int compare(String o1, String o2)
    {
        counter++;
        return o1.indexOf(s) - o2.indexOf(s);
    }
}
