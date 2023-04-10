package T2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateButtonHandler implements ActionListener {
    private final JTextField f1;

    public CalculateButtonHandler(JTextField f1) {
        this.f1 = f1;
    }

    public static int factorial(int x) {
        int res = 1;
        for (int i = 1; i <= x; ++i) res *= i;
        return res;
    }

    public static double expression(double x, double eps) {
        double res = 0.0;
        double term = Double.MAX_VALUE;
        for (int i = 0; Math.abs(term) >= eps; ++i) {
            term = Math.pow(-1, i) * Math.pow(x, 2*i) / factorial(2*i);
            res += term;
        }
        return res;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double a = Double.parseDouble(f1.getText());
            double ans = expression(a, 0.1);
            String result = "Сумма чисел равна " + ans;
            JOptionPane.showMessageDialog(null, result);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }
    }
}
