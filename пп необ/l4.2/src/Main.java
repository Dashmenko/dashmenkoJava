import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class Main {

    //Массив содержащий заголоки таблицы
    Object[] headers = { "Кинотеатр", "фильм", "жанр", "дата", "время" };

    //Массив содержащий информацию для таблицы
    Object[][] data = {
            { "барбарики", "оно1", "ужасы", "19.01.2021", "20:00:00" },
            { "око", "оно2", "ужасы", "19.01.2021", "21:00:00"  },
            { "холодильник", "оно3", "триллер", "19.01.2021", "20:30:00"   },
            { "октябрь", "удача", "мульт" , "19.01.2021", "12:00:00"  },
            { "мир", "кот в сапогах", "мульт", "19.01.2021", "10:00:00"   },
            { "дом2", "чебурашка", "драма", "19.01.2021", "17:00:00"   },
    };

    //Объект таблицы
    JTable jTabPeople;

    Main() {
        //Создаем новый контейнер JFrame
        JFrame jfrm = new JFrame("JTableExample");
        //Устанавливаем диспетчер компоновки
        jfrm.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        jfrm.setSize(450, 200);
        //Устанавливаем завершение программы при закрытии окна
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        jTabPeople = new JTable(data, headers);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        //Устаналиваем размеры прокручиваемой области
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(400, 100));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        jfrm.getContentPane().add(jscrlp);
        //Отображаем контейнер
        jfrm.setVisible(true);
    }

    //Функция main, запускающаяся при старте приложения
    public static void main(String[] args) {
        //Создаем фрейм в потоке обработки событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}