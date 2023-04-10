package T1;

import javax.swing.*;

class MyForm extends JFrame {
    public MyForm() {
        super("Первое Swing-приложение");
        // Окно
        setBounds(100, 50, 385, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Поле
        JLabel firstOperandLabel = new JLabel("Первый операнд:");
        firstOperandLabel.setBounds(10, 10, 350, 30);
        add(firstOperandLabel);
        JTextField firstOperandTextField = new JTextField();
        firstOperandTextField.setBounds(10, 50, 350, 30);
        add(firstOperandTextField);
        // Поле
        JLabel secondOperandLabel = new JLabel("Второй операнд:");
        secondOperandLabel.setBounds(10, 90, 350, 30);
        add(secondOperandLabel);
        JTextField secondOperandTextField = new JTextField();
        secondOperandTextField.setBounds(10, 130, 350, 30);
        add(secondOperandTextField);
        // Поле
        JLabel thirdOperandLabel = new JLabel("Третий операнд:");
        thirdOperandLabel.setBounds(10, 170, 350, 30);
        add(thirdOperandLabel);
        JTextField thirdOperandTextField = new JTextField();
        thirdOperandTextField.setBounds(10, 210, 350, 30);
        add(thirdOperandTextField);
        // Кнопка
        JButton calculateButton = new JButton("Вычислить сумму");
        calculateButton.setBounds(60, 290, 250, 30);
        calculateButton.addActionListener(
                new CalculateButtonHandler(
                        firstOperandTextField,
                        secondOperandTextField,
                        thirdOperandTextField
                )
        );
        add(calculateButton);
        validate();
        setVisible(true);
    }
}