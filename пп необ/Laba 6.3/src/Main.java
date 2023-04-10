import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends JFrame {
    Main() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 150);
        JPanel panel = new JPanel();
        add(panel);
        JTextField textField = new JTextField(25);
        JTextField textField2 = new JTextField(25);
        JButton button = new JButton("Click");
        panel.add(textField);
        panel.add(textField2);
        panel.add(button);

        button.addActionListener(e -> {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime start = LocalDateTime.parse(textField.getText(), f);
            LocalDateTime end = LocalDateTime.parse(textField2.getText(), f);
            Duration duration = Duration.between(start, end);

            String text = String.format("%dд %dч %dмин%n", duration.toDays(), duration.toHours() % 24,
                    duration.toMinutes() % 60);
            JOptionPane.showMessageDialog(this, text);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}