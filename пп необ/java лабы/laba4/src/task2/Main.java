package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<BooksInfo> readFromFile(File file) {
        List<BooksInfo> library = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                try {
                    BooksInfo booksInfo = new BooksInfo(sc.nextLine()
                            .replaceAll("( *)(;)( *)", "$2")
                            .split(";"));
                    library.add(booksInfo);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Incorrect data");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Warning: file not found");
        }
        return library;
    }

    public static void writeToFile(List<BooksInfo> library, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (BooksInfo book : library) {
                writer.write(book.getName());
                writer.write("; ");
                writer.write(book.getBook());
                writer.write("; ");
                writer.write(book.getAuthor());
                writer.write("; ");
                writer.write(book.getStartDate().toString());
                writer.write("; ");
                try {
                    writer.write(book.getFinishDate().toString());
                } catch (NullPointerException e) {
                    writer.write("-");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("src/task2/library.csv");
        List<BooksInfo> library = readFromFile(file);
        Scanner sc = new Scanner(System.in);
        Handler handler = new Handler(library);

        handler.helpInfo();
        int choose = 0;
        while (choose != 7) {
            System.out.print("> ");
            choose = sc.nextInt();
            switch (choose) {
                case 1 -> handler.showData();
                case 2 -> {
                    handler.addData();
                    writeToFile(library, file);
                }
                case 3 -> {
                    handler.updateData();
                    writeToFile(library, file);
                }
                case 4 -> {
                    handler.deleteData();
                    writeToFile(library, file);
                }
                case 5 -> {
                    handler.processData();
                    writeToFile(library, file);
                }
                case 6 -> handler.helpInfo();
                case 7 -> {}
                default -> System.out.println("Incorrect command. Input 6 for help info");
            }
        }
    }
}
