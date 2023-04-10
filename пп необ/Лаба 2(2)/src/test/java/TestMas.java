import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestMas
{
    @Test
    public void test1()
    {
        int[] arr1 = {1,4,5, 2,3,6};
        Assertions.assertEquals(9, new Mas(arr1, arr1.length).getMin());
    }

    @Test
    public void test2()
    {
        int[] arr2 = {2,3,6, 3,4,7};
        Assertions.assertEquals(11, new Mas(arr2, arr2.length).getMin());
    }

    @Test
    public void test3()
    {
        int[] arr3 = {5,6,9,6,7,10};
        Assertions.assertEquals(23,new Mas(arr3,arr3.length).getMin());
    }
}
