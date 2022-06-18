package Homework8app.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorListener implements ActionListener {

    private JTextField inputField;
    public static String lastOperator;
    public static String lastNumber;

    public OperatorListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        lastOperator = btn.getText();
        lastNumber = inputField.getText();
        inputField.setText(inputField.getText()+btn.getText());
    }
}
