import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestSegment
{
    @Test
    public void test()
    {
        Point p1 = new Point(2.9, -5.2, x1);
        Point p2 = new Point(2.5, -3, x1);
        Segment line = new Segment(p1, p2);
        Assertions.assertEquals(2.236,0.001);
    }

    @Test
    public void test2()
    {
        Point p1 = new Point(2.9, -5.2, x1);
        Point p2 = new Point(2.5, -3, x1);
        Segment line = new Segment(p1, p2);
        Point center = line.getMidpoint(p1,p2);
        Assertions.assertEquals(center.getX(), 2.7);
    }

    @Test
    public void test3()
    {
        Point p1 = new Point(2.9, -5.2, x1);
        Point p2 = new Point(2.5, -3, x1);
        Segment line = new Segment(p1, p2);
        Point center = line.getMidpoint(p1,p2);
        Assertions.assertEquals(center.getY(), -4.1);
    }
}
