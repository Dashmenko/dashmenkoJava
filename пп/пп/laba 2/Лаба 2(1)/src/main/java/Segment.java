import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Segment
{


    Segment(Point p1, Point p2, double R)          // еще один конструктор
    {
        this.X=p2.getX()-p1.getX();
        this.Y=p2.getY()-p1.getY();

        this.len = sqrt(4*pow(R, 2)-pow(sqrt(pow(X, 2) + pow(Y, 2)), 2));                    //7777777777777777
    }
    Segment (Point p1, Point p2)          // еще один конструктор
    {
        this.X1=p1.getX()+len;
        this.X2=p2.getX()+len;

        this.Y1=p1.getX()+len;
        this.Y2=p2.getX()+len;
    }

    public double getLen()
    {return len;}

    public double getX1(){return X1;}

    Point getMidpoint(Point p1, Point p2)
    {
        return new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    private double X, Y;
    public double len;
    private double X1,Y1;
    public double X2,Y2;
}
