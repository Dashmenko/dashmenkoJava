import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Runner {
    public static Point inputPoints() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input x: ");
        double x = Double.parseDouble(sc.next());
        System.out.print("Input y: ");
        double y = Double.parseDouble(sc.next());

        return new Point(x, y);
    }

    public static Point getThirdPoint(Point A, Point B) {
        double x;
        double y;

        x = ((A.getX() + B.getX()) + (A.getY() - B.getY())) / 2;
        y = ((A.getY() + B.getY()) - (A.getX() - B.getX())) / 2;

        return new Point(x, y);
    }

    public static Point getThirdPointTheSecond(Point A, Point B) {
        double x2;
        double y2;

        x2 = ((A.getX() + B.getX()) - (A.getY() - B.getY())) / 2;
        y2 = ((A.getY() + B.getY()) + (A.getX() - B.getX())) / 2;

        return new Point(x2, y2);
    }

    public static Circle createCircle(Point A, Point B) {
        Point C = getThirdPoint(A, B);

        Segment AB = new Segment(A, B);
        Segment BC = new Segment(B, C);
        Segment AC = new Segment(A, C);

        double perimeter;
        perimeter = AB.getLength() + AC.getLength() + BC.getLength();


        Point O = new Point();
        O.setX((A.getX() * BC.getLength() + B.getX() * AC.getLength() + C.getX() * AB.getLength())
                / perimeter);
        O.setY((A.getY() * BC.getLength() + B.getY() * AC.getLength() + C.getY() * AB.getLength())
                / perimeter);

        double radius = (AC.getLength() + BC.getLength() - AB.getLength()) / 2;

        return new Circle(O, radius);
    }

    public static circleTheSecond createCircleTheSecond(Point A, Point B) {
        Point D = getThirdPointTheSecond(A, B);

        Segment AB = new Segment(A, B);
        Segment BD = new Segment(B, D);
        Segment AD = new Segment(A, D);

        double perimeterTheSecond;
        perimeterTheSecond = AB.getLength() + BD.getLength() + AD.getLength();

        Point cen = new Point();
        cen.setX((A.getX() * BD.getLength() + B.getX() * AD.getLength() + D.getX() * AB.getLength())
                / perimeterTheSecond);
        cen.setY((A.getY() * BD.getLength() + B.getY() * AD.getLength() + D.getY() * AB.getLength())
                / perimeterTheSecond);

        double radiusTheSecond = (AD.getLength() + BD.getLength() - AB.getLength()) / 2;

        return new circleTheSecond(cen, radiusTheSecond);
    }

    public static void main(String[] args) {
        Point A = inputPoints();
        Point B = inputPoints();
        System.out.println();

        Circle circle = createCircle(A, B);
        circleTheSecond cirleThe2 = createCircleTheSecond(A, B);
        System.out.println("Center of circle: " + circle.getCenter().toString());
        System.out.println("Radius of circle: " + circle.getRadius());

        System.out.println("Center of second circle: " + cirleThe2.getCenter().toString());
        System.out.println("Radius of second circle: " + cirleThe2.getRadius());
    }
}
