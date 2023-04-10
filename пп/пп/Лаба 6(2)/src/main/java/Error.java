import javax.swing.*;

public class Error
{
    private JFrame frame = new JFrame("Error");
    private JLabel error = new JLabel("No number bigger than 3");
    Error()
    {
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setBounds(100, 100, 300, 100);
        error.setBounds(50,25,200,25);
        frame.add(error);
    }
}
