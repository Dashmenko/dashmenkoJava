import javax.swing.*;

class Form extends JFrame {
    public Form() {
        super("Рисунок");
        setBounds(100, 50, 380, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Picture());
        validate();
        setVisible(true);
    }
}