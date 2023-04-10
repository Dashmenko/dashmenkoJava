/**
 * Направленный отрезок
 */
public class Segment {
    private Point begin;
    private Point end;

    /**
     * Сохдаёт направленный отрезок с указанными началом и концом
     * @param begin начальная точка
     * @param end конечная точка
     */
    public Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     * @return начальная точка отрезка
     */
    public Point getBegin() {
        return begin;
    }

    /**
     * @return конечная точка отрезка
     */
    public Point getEnd() {
        return end;
    }

    /**
     * @return точка, являющаяся серединой отрезка
     */
    public Point getMiddlePoint() {
        return new Point((begin.getX() + end.getX()) / 2, (begin.getY() + end.getY()) / 2);
    }

    /**
     * @return длина направленного отрезка
     */
    public double length() {
        // передача текущего объекта в качестве параметра в конструктор класса Vector
        return new Vector(this).length();
    }
}
