package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Handler {
    private final List<Vector> basis;

    public Handler(List<Vector> basis) {
        this.basis = basis;
    }

    public void helpInfo() {
        System.out.println("Выберете одну из опций: ");
        System.out.println("1 - Просмотреть данные");
        System.out.println("2 - Редактировать данные");
        System.out.println("3 - Обработать дынные");
        System.out.println("4 - Help message");
        System.out.println("5 - Выход");
        System.out.println();
    }

    public void showData() {
        System.out.println(basis);
    }

    public void updateData() {
        System.out.print("Введите номер вектора, который вы хотите редактировать (0 - 2): ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        if (index > 2) {
            System.err.println("Базисом в 3-х мерном пространстве может быть только система, " +
                    "состоящая из 3-х векторов.");
            throw new ArrayIndexOutOfBoundsException();
        }

        System.out.print("x = ");
        double x = sc.nextDouble();
        System.out.print("y = ");
        double y = sc.nextDouble();
        System.out.print("z = ");
        double z = sc.nextDouble();

        basis.set(index, new Vector(x, y, z));
    }

    /**
     * Проверяет является ли система из 3-х векторов базисом.
     * Метод Шлапакова
     */
    public void processData() {
        // Deep clone object
        List<Vector> current = new ArrayList<>();
        List<Vector> prev = new ArrayList<>();
        for (Vector vector : basis) {
            current.add(vector.toClone());
            prev.add(vector.toClone());

        }

        // Идем по диагонали
        for (int i = 0; i < basis.size() - 1; ++i) {
            // Зануляем весь столбец под элементом
            for (int j = i + 1; j < basis.size(); ++j) {
                current.get(j).set(i, 0);
            }
            // x - строка
            for (int x = i + 1; x < basis.size(); ++x) {
                // y - столбец
                for (int y = i + 1; y < basis.size(); ++y) {
                    double newValue = prev.get(i).get(i) * prev.get(x).get(y)
                            - prev.get(i).get(y) * prev.get(x).get(i);
                    current.get(x).set(y, newValue);
                }
            }

            // clone current to prev
            for (int p = 0; p < current.size(); ++p) {
                prev.set(p, current.get(p).toClone());
            }
        }

        System.out.println(current);
        for (int i = 0; i < current.size(); ++i) {
            if (Double.compare(current.get(i).get(i), 0) == 0) {
                System.out.println("Система не является базисом");
                return;
            }
        }
        System.out.println("Система является базисом");
    }
}
