public class Runner {
    public static double[] Solut(double x1,double y1,double x2,double y2,double[] arr)
    {
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        System.out.println("Даны две точки: " + point1 + " и " + point2);
        /* отрезок между 2-мя точками */
        Segment segment = new Segment(point1, point2);
        System.out.println("Расстояние между точками: " + segment.length());
        /* серединный перпендикуляр */
        double dx=x1-x2;
        double dy=y1-y2;

        double x13,y13,x14,y14,x23,y23,x24,y24;
        x13 = x1 + dy;
        y13=y1-dx;
        x14=x2+dy;
        y14=y2-dx;
        //второй
        x23=x1-dy;
        y23=y1+dx;
        x24=x2-dy;
        y24=y2+dx;
        double cx1,cy1,cx2,cy2;
        cx1=x13 + (x2 - x13) / 2;
        cy1=y2 + (y13 - y2) / 2;
        cx2=x23 + (x2 - x23) / 2;
        cy2=y2 + (y23 - y2) / 2;
        System.out.println("Остальные вершины первого квадрата "+x13+ " " + y13+" и " + x14 +" "+ y14+" Второго " + x23+" " + y23+" и " + x24 +" "+ y24);
        double d=segment.length()*Math.sqrt(2);
        double r=d/2;
        arr[0]=cx1;
        arr[1]=cy1;
        arr[2]=cx2;
        arr[3]=cy2;
        arr[4]=r;
        return arr;
    }
    public static void main(String[] args) {
        double[] arr = new double[5];
        /* получение координат точек из аргументов командной строки */
        double x1 = 6;
        double y1 = 1;
        double x2 = 6;
        double y2 = 5;
        arr=Solut(x1,y1,x2,y2,arr);
        Point point = new Point(arr[0],arr[1]);
        Point point1 = new Point(arr[2],arr[3]);
        System.out.println("Центр 1 "+point.toString());
        System.out.println("Центр 2 "+point1.toString());
        System.out.println("Радиус окружности "+arr[4]);
    }
}