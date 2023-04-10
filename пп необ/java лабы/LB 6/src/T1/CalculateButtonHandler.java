package T1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateButtonHandler implements ActionListener {
    private final JTextField f1;
    private final JTextField f2;
    private final JTextField f3;

    public CalculateButtonHandler(JTextField f1, JTextField f2,JTextField f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Double a = Double.parseDouble(f1.getText());
            Double b = Double.parseDouble(f2.getText());
            Double c = Double.parseDouble(f3.getText());
            double ans = (c/b + 3*(a-b));
            String result = "Сумма чисел равна " + ans;
            JOptionPane.showMessageDialog(null, result);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }
    }
}
