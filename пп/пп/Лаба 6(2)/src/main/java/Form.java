import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame();
    private final JTextField number = new JTextField();
    private final JTextField accuracy = new JTextField(); //точность

    Form() {
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setTitle("Лабораторная работа 1(1)");

        number.setBounds(90, 30, 100, 20);
        accuracy.setBounds(90, 60, 100, 20);
        frame.add(number);
        frame.add(accuracy);

        JLabel numberlab = new JLabel("Число");
        numberlab.setBounds(20, 30, 100, 20);
        JLabel accurancylab = new JLabel("Точность");
        accurancylab.setBounds(20, 60, 100, 20);
        frame.add(numberlab);
        frame.add(accurancylab);

        JButton count = new JButton("Count");
        count.setBounds(90, 150, 100, 50);
        count.addActionListener(this);
        frame.add(count);
    }
    public static double Sum(double x, double h) {
        double res = 0.0;
        double term = Double.MAX_VALUE;
        for (int i = 0; Math.abs(term) > h; ++i) {
            term = Math.pow(-1, i) * Math.pow(x, 2*i+1) / (2*i+1);
            res += term;
        }
        return res;
    }

    public static double Atan(double x) {
        return Math.atan(x);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        double x = Double.parseDouble(number.getText());
        double h = Double.parseDouble(accuracy.getText());
        if (x > 3) {
            new Error();
            frame.setVisible(true);
            frame.dispose();

        } else {
            frame.setVisible(false);
            frame.dispose();
            new Answer(Sum(x, h), Atan(x));
        }
    }
}