package task2;

import java.util.Scanner;

public class Main {

    /**
     * Метод заменяет все однозначные числа (если они не являются частью слова)
     * на их буквенное представление.
     * Сначала добавляем в строку пробелы для распознования регулярных
     * выражений.
     * Знак $ указывает номер группы, которую нужно вставить вместо регулярного
     * выражения.
     * В конце убираем добавленные пробелы.
     */
    public static String parseString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.insert(0, " ");
        stringBuilder.append(" ");
        string = stringBuilder.toString();

        string = string.replaceAll("(\\W)(0)(\\W)", "$1zero$3");
        string = string.replaceAll("(\\W)(1)(\\W)", "$1one$3");
        string = string.replaceAll("(\\W)(2)(\\W)", "$1two$3");
        string = string.replaceAll("(\\W)(3)(\\W)", "$1three$3");
        string = string.replaceAll("(\\W)(4)(\\W)", "$1four$3");
        string = string.replaceAll("(\\W)(5)(\\W)", "$1five$3");
        string = string.replaceAll("(\\W)(6)(\\W)", "$1six$3");
        string = string.replaceAll("(\\W)(7)(\\W)", "$1seven$3");
        string = string.replaceAll("(\\W)(8)(\\W)", "$1eight$3");
        string = string.replaceAll("(\\W)(9)(\\W)", "$1nine$3");

        return string.strip();
    }

    public static void main(String[] args) {
        System.out.println("Input string to parse: ");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println(parseString(string));
    }
}
