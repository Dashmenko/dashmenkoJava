package T4;

import T4.comporators.StringComparatorPoint1;
import T4.comporators.StringComparatorPoint2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CalculateButtonHandler implements ActionListener {
    private final JTextArea text;
    private final JRadioButton sortMethod1;

    public CalculateButtonHandler(JTextArea text, JRadioButton sortMethod1) {
        this.text = text;
        this.sortMethod1 = sortMethod1;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {

            String message = "";
            String[] args = text.getText().split("\n");
            message += "Input array: " + Arrays.toString(args) + "\n";
            if (sortMethod1.isSelected()) {
                Arrays.sort(args, new StringComparatorPoint1("is"));
            } else {
                Arrays.sort(args, new StringComparatorPoint2("is", "o"));
            }
            message += "Sort:             " + Arrays.toString(args) + "\n";

            JOptionPane.showMessageDialog(null, message);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }
    }
}
