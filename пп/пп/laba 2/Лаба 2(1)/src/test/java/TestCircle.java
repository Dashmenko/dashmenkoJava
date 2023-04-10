import org.junit.jupiter.api.Test;

public class TestCircle
{
    @Test
    public void test()
    {
        Point p1 = new Point(3.9, -8, x1);
        Point p2 = new Point(1.4, 5.2, x1);
        Segment line = new Segment(p1, p2);
        Point center = line.getMidpoint(p1,p2);
    }

    @Test
    public void test2()
    {
        Point p1 = new Point(0.1, -8, x1);
        Point p2 = new Point(5.5, 6.1, x1);
        Segment line = new Segment(p1, p2);
        Point center = line.getMidpoint(p1,p2);
    }

}
