import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {
    public static void checkExpression(String expression) {
        String regex = "(-?[0-9]+[+*])*(-?[0-9])+";
        if (!Pattern.matches(regex, expression)) {
            throw new IllegalArgumentException();
        }
    }

    public static ArrayList<Integer> fillNumbers(String expression) {
        Pattern pattern = Pattern.compile("[+*]");
        String[] stringNumbers = pattern.split(expression);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < stringNumbers.length; ++i) {
            numbers.add(Integer.parseInt(stringNumbers[i]));
        }
        return numbers;
    }

    public static ArrayList<Character> fillSigns(String expression) {
        Pattern pattern = Pattern.compile("\\d");
        String[] stringNumbers = pattern.split(expression);
        ArrayList<Character> signs = new ArrayList<>();
        for (int i = 0; i < stringNumbers.length; ++i) {
            if (!stringNumbers[i].equals("")) {
                signs.add(stringNumbers[i].charAt(0));
            }
        }
        return signs;
    }

    public static int operation(int n1, int n2, char sign) {
        if (sign == '*') {
            return n1 * n2;
        } else if (sign == '+') {
            return n1 + n2;
        } else {
            throw new ArithmeticException();
        }
    }

    public static Node[][] fillMatrix(ArrayList<Integer> numbers,
                                      ArrayList<Character> signs) {
        Node[][] matrix = new Node[numbers.size()][numbers.size()];
        for (int i = 0; i < numbers.size(); ++i) {
            matrix[i][i] = new Node(numbers.get(i));
        }

        for (int k = 1; k < matrix.length; ++k) {
            for (int i = k; i < matrix.length; ++i) {
                int j = i - k;
                ArrayList<Integer> curPath = new ArrayList<>();
                int maxNum = Integer.MIN_VALUE;
                for (int m = 0; m < k; ++m) {
                    int el1 = matrix[i - 1 - m][j].number;
                    int el2 = matrix[i][k + j - m].number;
                    int num = operation(el1, el2, signs.get(i - 1 - m));
                    if (num > maxNum) {
                        maxNum = num;
                        curPath.clear();
                        curPath.addAll(matrix[i - 1 - m][j].path);
                        curPath.addAll(matrix[i][k + j - m].path);
                        curPath.add(i - 1 - m);
                    }
                }
                matrix[i][j] = new Node(maxNum);
                matrix[i][j].path.addAll(curPath);
            }
        }

        return matrix;
    }

    public static void printData(Node[][] matrix) {
        System.out.println("Path: " +
                matrix[matrix.length - 1][0].path.toString());
        System.out.println("Max value: " +
                matrix[matrix.length - 1][0].number);
    }

    public static void main(String[] args) {
        String expression = "1+2*-3";
        checkExpression(expression);
        ArrayList<Integer> numbers = fillNumbers(expression);
        ArrayList<Character> signs = fillSigns(expression);
        Node[][] matrix = fillMatrix(numbers, signs);

        printData(matrix);
    }
}
