import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        String s = "AAAaaa AAaa AAAAAaaaaaaaaa Aa AAAaaaa АААААААААААААААААААААААААААА";
        Arrays.stream(s.split(" "))
                .sorted(Comparator.comparingInt(e -> (int) e.chars().filter(Character::isLowerCase).count()))
                .forEach(System.out::println);
    }
}
