//import java.lang.reflect;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        args = new String[]{"jojojo", "jfsdhfkjs", "jodlkf", "iojo"};
        HeapSort<String> c1 = new HeapSort<>();

        Firstind qw=new Firstind("d");
        c1.sort(args,qw);
        System.out.println(Arrays.toString(args));
        System.out.println(qw.getCounter());

        Count rt=new Count("o");
        SelectSort<String> c2 = new SelectSort<>();
        c2.sort(args,rt);
        System.out.println(Arrays.toString(args));
        System.out.println(rt.getCounter());
    }

/*    System.out.println();
        System.out.print("Количество операций: ");
        System.out.print(c1.getCounter());
        System.out.println();
        System.out.println("По части строки");
    Comparator2 c2=new Comparator2(substr1, substr2);
        Arrays.sort(str,c2);
        for (String s : str) {
    System.out.print(s + "; ");
}
        System.out.println();
        System.out.print("Количество операций: ");
        System.out.print(c2.getCounter());
        */

}
