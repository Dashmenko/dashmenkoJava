package by.vsu;

public class Main {
    public static int factorial(int x) {
        int res = 1;
        for (int i = 1; i <= x; ++i) res *= i;
        return res;
    }
    //Math.abs(term) >= eps
    public static double expression(double x, double eps) {
        double res = 0.0;
        double term = Double.MAX_VALUE;
        for (int i = 0; Math.abs(term) >= eps; ++i) {
            term = Math.pow(-1, i) * Math.pow(x, 2*i) / factorial(2*i);
            res += term;
        }
        return res;
    }
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double eps = Double.parseDouble(args[1]);
        double radians = Math.toRadians(x);

        System.out.println("Math method: " + Math.cos(radians));
        System.out.println("Calculated value: " + expression(x, eps));
    }
}
