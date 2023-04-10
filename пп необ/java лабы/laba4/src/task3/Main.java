package task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeToFile(List<Vector> basis, File file) {
        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(basis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Vector> readFromFile(File file) {
        List<Vector> basis;
            try (InputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is)) {
                basis = (List<Vector>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                basis = new ArrayList<>();
                basis.add(null);
                basis.add(null);
                basis.add(null);
            }

        return basis;
    }

    public static void main(String[] args) {
        File file = new File("src/task3/basis.data");
        List<Vector> basis = readFromFile(file);
        Handler handler = new Handler(basis);
        Scanner sc = new Scanner(System.in);

        handler.helpInfo();
        int choose = 0;
        while (choose != 5) {
            System.out.print("> ");
            choose = sc.nextInt();
            switch (choose) {
                case 1 -> handler.showData();
                case 2 -> {
                    handler.updateData();
                    writeToFile(basis, file);
                }
                case 3 -> handler.processData();
                case 4 -> handler.helpInfo();
                case 5 -> {
                }
                default -> System.out.println("Incorrect command. Input 6 for help info");
            }
        }
    }
}
