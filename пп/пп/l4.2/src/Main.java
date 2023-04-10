
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;


public class Main {

    public static class MoviShow implements Serializable { // �������� �����
        private String MoviTheater;//����
        private String Film;
        private String Ganre;
        private String data;
        private String time;

        public MoviShow(String MoviTheater, String Film, String Ganre, String data, String time) { //�����������
            this.MoviTheater = MoviTheater;
            this.Film = Film;
            this.Ganre = Ganre;
            this.data = data;
            this.time = time;
        }

        //----�������----�������----\\
        public void setMoviTheater(String MoviTheater) {
            this.MoviTheater = MoviTheater;
        }

        public String getMoviTheater() {
            return MoviTheater;
        }

        //
        public void setFilm(String Film) {
            this.Film = Film;
        }

        public String getFilm() {
            return Film;
        }

        //
        public void setGanre(String Ganre) {
            this.Ganre = Ganre;
        }

        public String getGanre() {
            return Ganre;
        }

        //
        public void setData(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        //
        public void setTime(String time) {
            this.time = time;
        }

        public String getTime() {
            return time;
        }
//      \\----�������----�������----//

        @Override
        public String toString() { //��� � ������� ����������
            return "���������:" + MoviTheater + "\t\t, �����:" + Film + "\t, ����:" +
                    Ganre + "\t\t, ����: " + data + "\t , �����: " + time;
        }
    }


    public static class SortedByDate implements Comparator<MoviShow> //����������
    {
        public int compare(MoviShow obj1, MoviShow obj2) //�������� ������� ������
        {
            String data1s = obj1.getData(); //���� �� ���� - ����
            String data2s = obj2.getData(); // ���������� ������

            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // ������� ��������� ���
            LocalDate date1, date2;
            date1 = LocalDate.parse(data1s, formatterDate); // ����������� ������-���� � �����
            date2 = LocalDate.parse(data2s, formatterDate);
            if (date1.isAfter(date2)) { // ���������� ��
                return 1;
            } else if (date1.isBefore(date2)) {
                return -1;
            } else { // ���� 2 ���� ���������, �� ��������� �������� �� �������
                String time1s = obj1.getTime(); // ����� ���� ������� - �����
                String time2s = obj2.getTime(); // ���������� � ������
                DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm"); // ������� ��������� �������
                LocalTime time1, time2;
                time1 = LocalTime.parse(time1s, formatterTime); // ����������� �����-����� � �������
                time2 = LocalTime.parse(time2s, formatterTime);
                if (time1.isAfter(time2)) {
                    return 1;
                } else if (time1.isBefore(time2)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void PrintMenu() { //�������� ����
        System.out.println();
        System.out.println("\t                                                        ���� ���������              ");
        System.out.println("\t                                             �����o����� ������                  - 1");
        System.out.println("\t                                             ��������� ����� ����������          - 2");
        System.out.println("\t                                             ������������� ������������          - 3");
        System.out.println("\t                                             ������� ������������                - 4");
        System.out.println("\t                                             ���������� �� ��� � ����������      - 5");
        System.out.println("\t                                             ���������� �� �����                 - 6");
        System.out.println("\t                                             ��������� ������                    - 7");
        System.out.println("\t                                             ��������� ���������                 - 8");
        System.out.println();
    }

    public static void PrintMenu3() { // ���� ��� ������ 3
        System.out.println();
        System.out.println("\t                                                 ����� ���� ��� ��������������   ");
        System.out.println("\t                                             ���������                        - 1");
        System.out.println("\t                                             �����                            - 2");
        System.out.println("\t                                             ����                             - 3");
        System.out.println("\t                                             ���� ������                      - 4");
        System.out.println("\t                                             ����� ������                     - 5");
        System.out.println("\t                                             ��������� ��������������         - 6");
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);// ������
        char Button, Button1; // ������ �������� � ������� ���� � ������ 3

        ArrayList<MoviShow> currentMoviShow = new ArrayList<MoviShow>(); //������� ������ ������� ������ MoviShow
        try {
            InputStream is = new FileInputStream("D:\\��\\l4.2\\src\\text.csv"); //��������� ������ �� �����
            ObjectInputStream ois = new ObjectInputStream(is);
            currentMoviShow = (ArrayList<MoviShow>) ois.readObject(); // ���������� ��  � ������
            ois.close(); // ������� ����
        } catch (IOException | ClassNotFoundException e) { // ���� ������ �� �� ������ �������
            currentMoviShow = new ArrayList<>(); //����� ������ �������
        }
        while (true) { // ���� ���� ������
            PrintMenu(); //������� ����
            System.out.print("--> "); //������
            Button = in.next().charAt(0); //��� ������
            Scanner scanner = new Scanner(System.in);
            switch (Button) { // � ����������� �� ������ ������
                case ('1'):
                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        System.out.println(currentMoviShow.get(i)); // ������ ��������
                    }
                    break; // �������� ����� ��� ���������� �������� ���������� ������
                case ('2'):
                    System.out.println("������� �������� �� ������ ��������?");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        String MoviTheater = null, Film = null, Ganre = null, data = null, time = null;

                        System.out.println("������� ��������"); // �� ����������
                        MoviTheater = scanner.next();
                        System.out.println("������� �����");
                        Film = scanner.next();
                        System.out.println("������� ����");
                        Ganre = scanner.next();
                        System.out.println("������� ���� � ���� \"yyyy/MM/dd\" ");
                        data = scanner.next();
                        System.out.println("������� ����� � ���� \"HH:mm\" ");
                        time = scanner.next();
                        MoviShow myMoviShow = new MoviShow(MoviTheater, Film, Ganre, data, time); // ������� ������ ������
                        currentMoviShow.add(myMoviShow);// ��������� ��� � ������
                    }
                    break;
                case ('3'):
                    boolean exit = true; // ��� �����
                    int counter3 = -1;
                    System.out.println("������� ��������, �������� ������, ���� � ����� ��������, ������� ������ �������������");
                    String strMoviTheater = scanner.next();
                    String strFilm = scanner.next();
                    String strData = scanner.next();
                    String strTime = scanner.next();
                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        if (currentMoviShow.get(i).getMoviTheater().compareTo(strMoviTheater) == 0 &&
                                currentMoviShow.get(i).getFilm().compareTo(strFilm) == 0 &&
                                currentMoviShow.get(i).getData().compareTo(strData) == 0 &&
                                currentMoviShow.get(i).getTime().compareTo(strTime) == 0) {
                            counter3 = i; // ������� ����� ����������, �������� ����� ��������
                            break;
                        }
                    }
                    if (counter3 == -1) {
                        System.out.print("����� �������� ���");
                    } else {
                        while (exit) { //���� ������
                            PrintMenu3();//�������� ����
                            System.out.print("----> ");
                            Button1 = in.next().charAt(0);
                            switch (Button1) { // � �����������  �� ������ ������
                                case ('1'):
                                    System.out.println("������� ������ ���������");
                                    String new1 = scanner.next(); // ������ ����� �������� ��� ����
                                    currentMoviShow.get(counter3).setMoviTheater(new1); // � ������� ������� �������������� ����
                                    System.out.println("������ �����������");
                                    break;
                                case ('2'):
                                    System.out.println("������� ������ �����");
                                    String new2 = scanner.next();
                                    currentMoviShow.get(counter3).setFilm(new2);
                                    System.out.println("������ �����������");
                                    break;
                                case ('3'):
                                    System.out.println("������� ������ ����");
                                    String new3 = scanner.next();
                                    currentMoviShow.get(counter3).setGanre(new3);
                                    System.out.println("������ �����������");
                                    break;
                                case ('4'):
                                    System.out.println("������� ����� ���� ������");
                                    String new4 = scanner.next();
                                    currentMoviShow.get(counter3).setData(new4);
                                    System.out.println("������ �����������");
                                    break;
                                case ('5'):
                                    System.out.println("������� ����� ����� ������");
                                    String new5 = scanner.next();
                                    currentMoviShow.get(counter3).setTime(new5);
                                    System.out.println("������ �����������");
                                    break;
                                case ('6'):
                                    System.out.println("�������������� ���������");
                                    exit = false;
                                    break;
                                default:
                                    System.out.println("������ ����������� ������");
                                    break;
                            }
                        }
                        break;
                    }
                case ('4'):
                    int counter4 = -1;
                    System.out.println("������� ��������, �������� ������, ���� � ����� ��������, ������� ������ �������");
                    String strMoviTheater4 = scanner.next();
                    String strFilm4 = scanner.next();
                    String strData4 = scanner.next();
                    String strTime4 = scanner.next();
                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        if (currentMoviShow.get(i).getMoviTheater().compareTo(strMoviTheater4) == 0 &&
                                currentMoviShow.get(i).getFilm().compareTo(strFilm4) == 0 &&
                                currentMoviShow.get(i).getData().compareTo(strData4) == 0 &&
                                currentMoviShow.get(i).getTime().compareTo(strTime4) == 0) {
                            counter4 = i; // ������� ����� ����������, ������� ����� �������
                            break;
                        }
                    }
                    if (counter4 == -1) {
                        System.out.print("����� �������� ���");
                    } else {
                        currentMoviShow.remove(counter4);
                        System.out.println("�������� �����������");
                    }
                    break;
                case ('5'):
                    System.out.println("������� �������� � ����, ���� ��������� ����������");
                    String strMoviTheater5 = scanner.next();
                    String strData5 = scanner.next();
                    ArrayList<MoviShow> MoviTheaterAndDataList = new ArrayList<>(); //������� ����� ������

                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        if (currentMoviShow.get(i).getMoviTheater().compareToIgnoreCase(strMoviTheater5) == 0 && // ���� � i-��� �������� ��������� �������� � �������
                                currentMoviShow.get(i).getData().compareTo(strData5) == 0) { // � ���� ������
                            MoviTheaterAndDataList.add(currentMoviShow.get(i)); // �� ��������� ��� � ����� ������
                        }
                    }
                    Collections.sort(MoviTheaterAndDataList, new SortedByDate()); // �������� ����������� �� ����������
                    for (int i = 0; i < MoviTheaterAndDataList.size(); i++) {
                        System.out.println(MoviTheaterAndDataList.get(i)); // ������� ������
                    }

                    break;
                case ('6'):
                    System.out.println("������� ����, ���� ��������� ����������");
                    String strGanre6 = scanner.next(); // ������ ������ ����
                    ArrayList<MoviShow> GanreList = new ArrayList<>(); // ������� ������ �� ������

                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        if(currentMoviShow.get(i).getGanre().compareToIgnoreCase(strGanre6) ==0 ){ // ���� ���� ���� ��������� � ��������
                            GanreList.add(currentMoviShow.get(i)); // ������� ��� � ������
                        }
                    }

                    Collections.sort(GanreList, new SortedByDate()); // ��������� � ���� ������ ��������������

                    for (int i = 0; i < GanreList.size(); i++) {
                        System.out.println(GanreList.get(i)); // ������� ������
                    }

                    break;
                case ('7'):
                    try {
                        OutputStream os = new FileOutputStream("D:\\��\\l4.2\\src\\text.csv");
                        ObjectOutputStream oos = new ObjectOutputStream(os);
                        oos.writeObject(currentMoviShow); // ��������� �� � ����
                        oos.close();
                    } catch (IOException a) {
                        System.out.println("���������� ��������� ����");
                    }
                    break;
                case ('8'):
                    System.out.println("��������� ���������");
                    System.exit(0); //���������
                default:
                    System.out.println("������ ����������� ������"); // ���� ����� ������
                    break;

            }
        }
    }
}