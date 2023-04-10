package by.vsu;

public class Main {
    public static double expression(double x, double eps) {
        double res = 0.0;
        double term = Double.MAX_VALUE;
        for (int i = 0; Math.abs(term) > eps; ++i) {
            term = Math.pow(-1, i) * Math.pow(x, 2*i+1) / (2*i+1);
            res += term;
        }
        return res;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double eps = Double.parseDouble(args[1]);

        System.out.println("Math method: " + Math.atan(x));
        System.out.println("Calculated value: " + expression(x, eps));
    }
}

