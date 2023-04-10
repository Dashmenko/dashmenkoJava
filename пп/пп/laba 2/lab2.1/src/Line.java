/* Прямая в плоскости
        */
public class Line {
    private double a;
    private double b;
    private double c;

    /**
     * Создаёт серединного перпендикуляра к отрезку
     * @param segment отрезок
     */
    public Line(Segment segment) {
        /* вызов другого конструктора этого же класса */
        this(segment.getMiddlePoint(), new Vector(new Segment(segment.getMiddlePoint(), segment.getBegin())));
    }

    /**
     * Создаёт прямую, проходящую через точку, перпендикулярно вектору
     * @param p точка, через которую проходит прямая
     * @param n вектор-перпендикуляр к прямой
     */
    public Line(Point p, Vector n) {
        a = n.x;
        b = n.y;
        c = -(a * p.getX() + b * p.getY());
    }

    /**
     * @return коэффициент перед абсциссой в уравнении прямой
     */
    public double getA() {
        return a;
    }

    /**
     * @return коэффициент перед ординатой в уравнении прямой
     */
    public double getB() {
        return b;
    }

    /**
     * @return свободный коэффициент в уравнении прямой
     */
    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "(" + a + ")x + (" + b + ")y + (" + c + ") = 0";
    }
}