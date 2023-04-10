package task1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Входная подстрока для 1-й части задачи: ");
        String substring = sc.next();
        FirstComparator firstComparator = new FirstComparator(substring);
        Arrays.sort(args, firstComparator);
        System.out.println(Arrays.toString(args));
        System.out.println("Сравните время: " + firstComparator.getCompareCounter());

        System.out.println("Входная подстрока для 2-й части задачи: ");
        String substringS1 = sc.next();
        String substringS2 = sc.next();
        SecondComparator secondComparator
                = new SecondComparator(substringS1, substringS2);
        Arrays.sort(args, secondComparator);
        System.out.println(Arrays.toString(args));
        System.out.println("Сравните время: " + secondComparator.getCompareCounter());
    }
}
