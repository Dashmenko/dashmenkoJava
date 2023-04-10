import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        double x1, y1, x2, y2, R;
        System.out.print("Введите координаты x1 и у1: ");
        x1 = in.nextDouble();
        y1 = in.nextDouble();
        System.out.print("Введите координаты x2 и у2: ");
        x2 = in.nextDouble();
        y2 = in.nextDouble();
        Point A = new Point (x1, y1);
        Point B = new Point (x2, y2);
        System.out.print("Введите радиус R: ");
        R = in.nextDouble();

        Segment line = new Segment (A, B, R);
        Circle circle = new Circle (line.getLen());

        Square square = new Square (A,B);
        square.Points(A,B);

        System.out.println("Длина стороны квадрата: " + line.getLen());
        System.out.println(square);
    }
}
