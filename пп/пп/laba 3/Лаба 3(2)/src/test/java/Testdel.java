import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Testdel
{
    @Test
    public void test1()
    {
        String s = "kjsds/*dkd*/kjds";
        StringBuilder s1 = new StringBuilder(s);
        Assertions.assertEquals( "kjsdskjds",Main.del(s1).toString());
    }

    @Test
    public void test2()
    {
        String s = "k/jsds/*dkd*/kjds";
        StringBuilder s1 = new StringBuilder(s);
        Assertions.assertEquals("k/jsdskjds",Main.del(s1).toString());
    }

    @Test
    public void test3()
    {
        String s = "kjsds/*dkd*/kj/ds";
        StringBuilder s1 = new StringBuilder(s);
        Assertions.assertEquals( "kjsdskj/ds",Main.del(s1).toString());
    }

    @Test
    public void test4()
    {
        String s = "kjsds/*dkdkjds";
        StringBuilder s1 = new StringBuilder(s);
        Assertions.assertEquals( "kjsds/*dkdkjds",Main.del(s1).toString());
    }
    @Test
    public void test5()
    {
        String s = "k/*jsd*/s/*dkd*/kjds";
        StringBuilder s1 = new StringBuilder(s);
        Assertions.assertEquals( "kskjds",Main.del(s1).toString());
    }

}
