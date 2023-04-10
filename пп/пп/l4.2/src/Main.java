
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

    public static class MoviShow implements Serializable { // основной класс
        private String MoviTheater;//поля
        private String Film;
        private String Ganre;
        private String data;
        private String time;

        public MoviShow(String MoviTheater, String Film, String Ganre, String data, String time) { //конструктор
            this.MoviTheater = MoviTheater;
            this.Film = Film;
            this.Ganre = Ganre;
            this.data = data;
            this.time = time;
        }

        //----сеттеры----геттеры----\\
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
//      \\----сеттеры----геттеры----//

        @Override
        public String toString() { //что б красиво выводилось
            return "Кинотеатр:" + MoviTheater + "\t\t, фильм:" + Film + "\t, жанр:" +
                    Ganre + "\t\t, дата: " + data + "\t , время: " + time;
        }
    }


    public static class SortedByDate implements Comparator<MoviShow> //компаратор
    {
        public int compare(MoviShow obj1, MoviShow obj2) //получают обьекты класса
        {
            String data1s = obj1.getData(); //берём их поля - даты
            String data2s = obj2.getData(); // записываем строки

            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // создаем форматтер дат
            LocalDate date1, date2;
            date1 = LocalDate.parse(data1s, formatterDate); // преобразуем строки-даты к датам
            date2 = LocalDate.parse(data2s, formatterDate);
            if (date1.isAfter(date2)) { // сравниваем их
                return 1;
            } else if (date1.isBefore(date2)) {
                return -1;
            } else { // если 2 даты совподают, то запускаем проверку по времени
                String time1s = obj1.getTime(); // берем поля обектов - время
                String time2s = obj2.getTime(); // записываем в строки
                DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm"); // создаем форматтер времени
                LocalTime time1, time2;
                time1 = LocalTime.parse(time1s, formatterTime); // преобразуем стрки-время к времени
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

    public static void PrintMenu() { //основное меню
        System.out.println();
        System.out.println("\t                                                        Меню программы              ");
        System.out.println("\t                                             Просмoтреть данные                  - 1");
        System.out.println("\t                                             Добавлять новых кинопоказы          - 2");
        System.out.println("\t                                             Редактировать существующие          - 3");
        System.out.println("\t                                             Удалить существующие                - 4");
        System.out.println("\t                                             Сортировка по дню в кинотеатре      - 5");
        System.out.println("\t                                             Сортировка по жанру                 - 6");
        System.out.println("\t                                             Сохранить данные                    - 7");
        System.out.println("\t                                             Завершить программу                 - 8");
        System.out.println();
    }

    public static void PrintMenu3() { // меню для пункта 3
        System.out.println();
        System.out.println("\t                                                 Выбор поля для редактирования   ");
        System.out.println("\t                                             Кинотеатр                        - 1");
        System.out.println("\t                                             Фильм                            - 2");
        System.out.println("\t                                             Жанр                             - 3");
        System.out.println("\t                                             Дата показа                      - 4");
        System.out.println("\t                                             Время показа                     - 5");
        System.out.println("\t                                             Завершить редактирование         - 6");
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);// сканер
        char Button, Button1; // кнопки действия в главном меню и пункте 3

        ArrayList<MoviShow> currentMoviShow = new ArrayList<MoviShow>(); //создаем список обьктов класса MoviShow
        try {
            InputStream is = new FileInputStream("D:\\пп\\l4.2\\src\\text.csv"); //исчитывем данные из файлы
            ObjectInputStream ois = new ObjectInputStream(is);
            currentMoviShow = (ArrayList<MoviShow>) ois.readObject(); // зосовывеам их  в список
            ois.close(); // закртыь файл
        } catch (IOException | ClassNotFoundException e) { // если почему то не смогли считать
            currentMoviShow = new ArrayList<>(); //тогда список нулевой
        }
        while (true) { // пока цикл правда
            PrintMenu(); //печатам меню
            System.out.print("--> "); //курсор
            Button = in.next().charAt(0); //для кнопки
            Scanner scanner = new Scanner(System.in);
            switch (Button) { // в зависимости от выбора кнопки
                case ('1'):
                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        System.out.println(currentMoviShow.get(i)); // просто печатаем
                    }
                    break; // ключевое слово для завершения действия определённо кнопки
                case ('2'):
                    System.out.println("сколько объектов вы хотите добавить?");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        String MoviTheater = null, Film = null, Ganre = null, data = null, time = null;

                        System.out.println("введите кинотеар"); // их заполнение
                        MoviTheater = scanner.next();
                        System.out.println("введите фильм");
                        Film = scanner.next();
                        System.out.println("введите жанр");
                        Ganre = scanner.next();
                        System.out.println("введите дату в виде \"yyyy/MM/dd\" ");
                        data = scanner.next();
                        System.out.println("введите время в виде \"HH:mm\" ");
                        time = scanner.next();
                        MoviShow myMoviShow = new MoviShow(MoviTheater, Film, Ganre, data, time); // создаем обьект класса
                        currentMoviShow.add(myMoviShow);// доюовляем его в список
                    }
                    break;
                case ('3'):
                    boolean exit = true; // для цикла
                    int counter3 = -1;
                    System.out.println("Введите кинотетр, название фильма, дату и вермя премьеры, которую будете редактировать");
                    String strMoviTheater = scanner.next();
                    String strFilm = scanner.next();
                    String strData = scanner.next();
                    String strTime = scanner.next();
                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        if (currentMoviShow.get(i).getMoviTheater().compareTo(strMoviTheater) == 0 &&
                                currentMoviShow.get(i).getFilm().compareTo(strFilm) == 0 &&
                                currentMoviShow.get(i).getData().compareTo(strData) == 0 &&
                                currentMoviShow.get(i).getTime().compareTo(strTime) == 0) {
                            counter3 = i; // находим номер кинопоказа, которого будем редачить
                            break;
                        }
                    }
                    if (counter3 == -1) {
                        System.out.print("Такой премьеры нет");
                    } else {
                        while (exit) { //пока правда
                            PrintMenu3();//печатаем меню
                            System.out.print("----> ");
                            Button1 = in.next().charAt(0);
                            switch (Button1) { // в зависимости  от выбора кнопки
                                case ('1'):
                                    System.out.println("Введите другой кинотеатр");
                                    String new1 = scanner.next(); // вводим новое значения для поля
                                    currentMoviShow.get(counter3).setMoviTheater(new1); // с помощью сеттара перезаписываем поле
                                    System.out.println("Замена произведена");
                                    break;
                                case ('2'):
                                    System.out.println("Введите другой фильм");
                                    String new2 = scanner.next();
                                    currentMoviShow.get(counter3).setFilm(new2);
                                    System.out.println("Замена произведена");
                                    break;
                                case ('3'):
                                    System.out.println("Введите другой жанр");
                                    String new3 = scanner.next();
                                    currentMoviShow.get(counter3).setGanre(new3);
                                    System.out.println("Замена произведена");
                                    break;
                                case ('4'):
                                    System.out.println("Введите новую дату показа");
                                    String new4 = scanner.next();
                                    currentMoviShow.get(counter3).setData(new4);
                                    System.out.println("Замена произведена");
                                    break;
                                case ('5'):
                                    System.out.println("Введите новое время показа");
                                    String new5 = scanner.next();
                                    currentMoviShow.get(counter3).setTime(new5);
                                    System.out.println("Замена произведена");
                                    break;
                                case ('6'):
                                    System.out.println("Редактирование завершено");
                                    exit = false;
                                    break;
                                default:
                                    System.out.println("Нажата неизвестная кнопка");
                                    break;
                            }
                        }
                        break;
                    }
                case ('4'):
                    int counter4 = -1;
                    System.out.println("Введите кинотетр, название фильма, дату и вермя премьеры, которую будете удалять");
                    String strMoviTheater4 = scanner.next();
                    String strFilm4 = scanner.next();
                    String strData4 = scanner.next();
                    String strTime4 = scanner.next();
                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        if (currentMoviShow.get(i).getMoviTheater().compareTo(strMoviTheater4) == 0 &&
                                currentMoviShow.get(i).getFilm().compareTo(strFilm4) == 0 &&
                                currentMoviShow.get(i).getData().compareTo(strData4) == 0 &&
                                currentMoviShow.get(i).getTime().compareTo(strTime4) == 0) {
                            counter4 = i; // находим номер кинопоказа, который будем удалять
                            break;
                        }
                    }
                    if (counter4 == -1) {
                        System.out.print("Такой премьеры нет");
                    } else {
                        currentMoviShow.remove(counter4);
                        System.out.println("Удаление произведено");
                    }
                    break;
                case ('5'):
                    System.out.println("Введите кинотетр и дату, чтоб составить расписание");
                    String strMoviTheater5 = scanner.next();
                    String strData5 = scanner.next();
                    ArrayList<MoviShow> MoviTheaterAndDataList = new ArrayList<>(); //создаем новый список

                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        if (currentMoviShow.get(i).getMoviTheater().compareToIgnoreCase(strMoviTheater5) == 0 && // если у i-ого элемента совпадает название с введёным
                                currentMoviShow.get(i).getData().compareTo(strData5) == 0) { // и дата показа
                            MoviTheaterAndDataList.add(currentMoviShow.get(i)); // то доюовляем его в новый список
                        }
                    }
                    Collections.sort(MoviTheaterAndDataList, new SortedByDate()); // вызываем сортировщик по хронологии
                    for (int i = 0; i < MoviTheaterAndDataList.size(); i++) {
                        System.out.println(MoviTheaterAndDataList.get(i)); // выводим списки
                    }

                    break;
                case ('6'):
                    System.out.println("Введите жанр, чтоб составить расписание");
                    String strGanre6 = scanner.next(); // просим ввсети жанр
                    ArrayList<MoviShow> GanreList = new ArrayList<>(); // создаем список по жанрам

                    for (int i = 0; i < currentMoviShow.size(); i++) {
                        if(currentMoviShow.get(i).getGanre().compareToIgnoreCase(strGanre6) ==0 ){ // если поле жанр совпадает с введённым
                            GanreList.add(currentMoviShow.get(i)); // заносим его в список
                        }
                    }

                    Collections.sort(GanreList, new SortedByDate()); // сортируем и этот список хронолонгичеки

                    for (int i = 0; i < GanreList.size(); i++) {
                        System.out.println(GanreList.get(i)); // выводим списки
                    }

                    break;
                case ('7'):
                    try {
                        OutputStream os = new FileOutputStream("D:\\пп\\l4.2\\src\\text.csv");
                        ObjectOutputStream oos = new ObjectOutputStream(os);
                        oos.writeObject(currentMoviShow); // сохроняем их в файл
                        oos.close();
                    } catch (IOException a) {
                        System.out.println("Невозможно сохранить файл");
                    }
                    break;
                case ('8'):
                    System.out.println("Программа завершена");
                    System.exit(0); //завршение
                default:
                    System.out.println("Нажата неизвестная кнопка"); // если херню нажали
                    break;

            }
        }
    }
}