public class Circle
{
    Circle(Point center, double R)
    {
        this.center = center;
        this.r = R;
    }

    Circle(double R)
    {this.r=R;}


    double getR()
    {
        return r;
    }

    Point getCenter()                // чтение поля Center
    {
        return center;
    }

    private final double r;
    private Point center;
}
