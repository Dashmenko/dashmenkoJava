
public class Point
{
    private double x;
    private double y;
    private double X1;
    private double Y1;


    Point (double x, double y) {
        this.x = x;
        this.y = y;

        this.X1 = X1;
        this.Y1 = Y1;
    }

    double getX()
    {
        return x;
    }

    double getY()
    {
        return y;
    }
    double getX1()
    {
        return X1;
    }
    double getY1()
    {
        return Y1;
    }

    public String toString() {
        return "(" + this.x + "; " + this.y + ")";
    }
   /* public String toString1() {
        return "(" + this.X1 + "; " + this.y + ")";
    }
    */
}


