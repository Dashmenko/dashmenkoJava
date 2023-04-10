package task2;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Handler {
    private final List<BooksInfo> library;

    public Handler(List<BooksInfo> library) {
        this.library = library;
    }

    public void helpInfo() {
        System.out.println("Выберете одну из опций: ");
        System.out.println("1 - Просмотреть данные");
        System.out.println("2 - Добавить данные");
        System.out.println("3 - Редактировать данные");
        System.out.println("4 - Удалить данные");
        System.out.println("5 - Обработать дынные");
        System.out.println("6 - Help message");
        System.out.println("7 - Выход");
        System.out.println();
    }

    public void showData() {
        for (BooksInfo book : library) {
            System.out.println(book);
        }
    }

    public void addData() {
        System.out.println("Введите данные ->");
        library.add(null);
        addData(library.size());
    }

    public void addData(int row) {
        Scanner sc = new Scanner(System.in);
        BooksInfo book = new BooksInfo();
        System.out.print("ФИО читателя: ");
        book.setName(sc.next());
        System.out.print("Название книги: ");
        book.setBook(sc.next());
        System.out.print("Автор книги: ");
        book.setAuthor(sc.next());
        System.out.print("Дата выдачи в формате yy:mm:dd: ");
        book.setStartDate(new Date(sc.next()));
        System.out.print("Дата возврата в формате yy:mm:dd, либо '-': ");
        String finishDate = sc.next();
        if (finishDate.equals("-")) {
            book.setFinishDate(null);
        } else {
            book.setFinishDate(new Date(finishDate));
        }
        library.set(row, book);
    }

    public void updateData() {
        System.out.print("Выберете номер строки для измениния (0 - "
                + (library.size() - 1) + "): ");
        int row = new Scanner(System.in).nextInt();
        System.out.println(row + ": " + library.get(row));
        System.out.println("Введите новые данные ->");
        addData(row);
    }

    public void deleteData() {
        System.out.print("Какую строку хотите удалить (0 - "
                + (library.size() - 1) + "): ");
        int row = new Scanner(System.in).nextInt();
        library.remove(row);
    }

    public void processData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Имя читателя: ");
        String name = sc.nextLine();
        System.out.print("Дата в формате yy:mm:dd: ");
        String data = sc.next();
        Date needDate = new Date(data);

        System.out.println("[");
        for (BooksInfo book : library) {
            if (book.getName().equals(name)) {
                long finish = book.getFinishDate() == null
                        ? new GregorianCalendar().getTimeInMillis()
                        : book.getFinishDate().getInSeconds();
                long start = book.getStartDate().getInSeconds();
                long need = needDate.getInSeconds();
                if (finish > need && start < need) {
                    System.out.println(book.getBook());
                }
            }
        }
        System.out.println("]");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите книгу: ");
        String bookName = scanner.nextLine();
        System.out.print("Введите автора: ");
        String author = scanner.nextLine();
        System.out.println("[");
        for (BooksInfo book : library) {
            if (book.getBook().equals(bookName)
                    && book.getAuthor().equals(author)) {
                System.out.println(book.getName());
            }
        }
        System.out.println("]");
    }
}
