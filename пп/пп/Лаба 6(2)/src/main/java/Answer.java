import javax.swing.*;

public class Answer extends JFrame
{
    private JFrame answer = new JFrame("Ответ");
    private JLabel sumlab = new JLabel("Сумма");
    private JLabel explab = new JLabel("Atan");
    private JLabel sumans = new JLabel();
    private JLabel expans = new JLabel();
    Answer(double sum, double atan)
    {
        answer.setBounds(100,100,300,200);
        answer.setVisible(true);
        answer.setLayout(null);
        sumlab.setBounds(10, 60 , 100,20);
        explab.setBounds(10,90,100,20);
        answer.add(sumlab);
        answer.add(explab);

        sumans.setBounds(60, 60 , 200,20);
        expans.setBounds(60,90,200,20);
        sumans.setText(Double.toString(sum));
        expans.setText(Double.toString(atan));
        answer.add(sumans);
        answer.add(expans);
    }

}
