import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void getLengthTest() {
        Point A = new Point(-1, 3);
        Point B = new Point(6, 2);
        Segment AB = new Segment(A, B);
        assertEquals(
                5 * Math.sqrt(2),
                AB.getLength(),
                0.00000001
        );
    }

    @Test
    void getMiddlePointTest() {
        Point A = new Point(2, 4);
        Point B = new Point(6, 5);
        Segment AB = new Segment(A, B);
        assertEquals(
                "(4.0, 4.5)",
                AB.getMiddlePoint().toString()
        );
    }

    @Test
    void getThirdPointTest() {
        Point A = new Point(2, 4);
        Point B = new Point(6, 5);
        Point C = Runner.getThirdPoint(A, B);
        assertEquals(
                "(3.5, 6.5)",
                C.toString()
        );
    }

    @Test
    void createCircleTest() {
        Point A = new Point(0, 6);
        Point B = new Point(4, 5);
        Circle circle = Runner.createCircle(A, B);
        assertEquals(
                2.207,
                circle.getCenter().getX(),
                0.001
        );
        assertEquals(
                6.328,
                circle.getCenter().getY(),
                0.001
        );
        assertEquals(
                0.853,
                circle.getRadius(),
                0.001
        );
    }
}