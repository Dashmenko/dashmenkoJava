package T4;

import javax.swing.*;

class MyForm extends JFrame {
    public MyForm() {
        super("Четвертое Swing-приложение");
        // Окно
        setBounds(100, 50, 385, 255);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Кнопки
        JRadioButton first = new JRadioButton("1");
        first.setBounds(10, 10, 100, 30);
        first.setSelected(true);
        add(first);
        // Кнопки
        JRadioButton second = new JRadioButton("2");
        second.setBounds(10, 40, 100, 30);
        add(second);
        // Кнопки
        ButtonGroup group = new ButtonGroup();
        group.add(first);
        group.add(second);
        // Входные данные
        JTextArea textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10, 70, 350, 100);
        add(scroll);
        // Кнопка
        JButton calculateButton = new JButton("Отсортировать");
        calculateButton.setBounds(60, 180, 250, 30);
        calculateButton.addActionListener(
                new CalculateButtonHandler(
                        textArea,
                        first
                )
        );
        add(calculateButton);
        validate();
        setVisible(true);
    }
}