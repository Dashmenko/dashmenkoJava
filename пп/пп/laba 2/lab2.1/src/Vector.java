/**
 * Вектор в плоскости
 * */
public class Vector extends Point {
    /**
     * Создает вектор, соответствующий направленному отрезку
     * @param segment направленный отрезок
     */
    public Vector(Segment segment) {
        /*
         * вызов констрктора суперкласса Point
         * */
        super(segment.getBegin().getX() - segment.getEnd().getX(),
                segment.getBegin().getY() - segment.getEnd().getY());
    }

    /**
     * @return длина вектора
     */
    public double length() {
        return Math.hypot(x, y);
    }
}
