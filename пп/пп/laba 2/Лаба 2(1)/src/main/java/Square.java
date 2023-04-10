public class Square
{
    Square(Point A, Point B)
    {
        this.A = new Point(A.getX(), A.getY());
        this.B = new Point(B.getX(), B.getY());
    }

    public void Points(Point A, Point B)
    {

        this.C = new Point(B.getX() + B.getX1(), B.getY());
        this.D = new Point(A.getX()+A.getX1() , A.getY());
    }


    public String toString() {
        return "A" + A + "\nB" + B + "\nC" + C + "\nD" + D;
    }

    private Point A;

    private Point B;
    private Point C;
    private Point D;
}
