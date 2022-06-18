package Homework8app.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class EqualButtonListener implements ActionListener {
    private JTextField inputField;

    public EqualButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DecimalFormat decimalFormat =new DecimalFormat("###.##");
        String newInputField;
        StringBuilder sb = new StringBuilder(inputField.getText());
         sb= new StringBuilder(sb.substring(sb.indexOf(OperatorListener.lastOperator)+1));
        switch (OperatorListener.lastOperator) {
            case "+":
                newInputField = decimalFormat.format(Double.parseDouble(OperatorListener.lastNumber) + Double.parseDouble(sb.toString()));
                break;
            case "-":
                newInputField = decimalFormat.format(Double.parseDouble(OperatorListener.lastNumber) - Double.parseDouble(sb.toString()));
                break;
            case "*":
                newInputField = decimalFormat.format(Double.parseDouble(OperatorListener.lastNumber) * Double.parseDouble(sb.toString()));
                break;
            case "÷":
                if((sb.toString().equals("0"))){
                    newInputField="деление на 0";
                    break;
                }
                newInputField = decimalFormat.format(Double.parseDouble(OperatorListener.lastNumber) / Double.parseDouble(sb.toString()));
                break;
            case "%":
                newInputField = decimalFormat.format(Double.parseDouble(OperatorListener.lastNumber) / 100);
                break;
            case "^":
                newInputField = decimalFormat.format(Double.parseDouble(OperatorListener.lastNumber)*Double.parseDouble(OperatorListener.lastNumber));
                break;
            case "√":
                newInputField = decimalFormat.format(Math.sqrt(Double.parseDouble(OperatorListener.lastNumber)));
                break;
            default:
                newInputField = "Ошибка";
                break;
        }
        inputField.setText(newInputField);
        //OperatorListener.lastOperator=null;


    }
}
