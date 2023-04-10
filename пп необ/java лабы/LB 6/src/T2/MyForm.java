package T2;

import javax.swing.*;

class MyForm extends JFrame {
    public MyForm() {
        super("Второе Swing-приложение");
        // Окно
        setBounds(100, 50, 385, 180);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Поле
        JLabel firstOperandLabel = new JLabel("Первый операнд:");
        firstOperandLabel.setBounds(10, 10, 350, 30);
        add(firstOperandLabel);
        JTextField firstOperandTextField = new JTextField();
        firstOperandTextField.setBounds(10, 50, 350, 30);
        add(firstOperandTextField);
        // Кнопка
        JButton calculateButton = new JButton("Вычислить сумму ряда");
        calculateButton.setBounds(60, 90, 250, 30);
        calculateButton.addActionListener(
                new CalculateButtonHandler(
                        firstOperandTextField
                )
        );
        add(calculateButton);
        validate();
        setVisible(true);
    }
}