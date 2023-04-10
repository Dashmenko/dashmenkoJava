public class Segment {
    private Point begin;
    private Point end;

    public Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public double getLength() {
        return Math.hypot((end.getX() - begin.getX()), (end.getY() - begin.getY()));
    }

    }