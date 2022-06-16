package Homework8app;

import Homework8app.components.NumberJButton;
import Homework8app.components.OperatorsJButton;
import Homework8app.listeners.ButtonListener;
import Homework8app.listeners.ClearButtonActionListener;
import Homework8app.listeners.EqualButtonListener;
import Homework8app.listeners.OperatorListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {
    public JTextField inputField;
//    private JTextField outputField;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(200, 200, 350, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setJMenuBar(createMenu());
        setLayout(new BorderLayout());
        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuBar.add(new JMenuItem("Help"));
        menuBar.add(new JMenuItem("About"));
        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        menuBar.add(exitItem);
        exitItem.addActionListener(e -> System.exit(0));
        return menuBar;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        ActionListener buttonListener = new ButtonListener(inputField);


        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(), BorderLayout.WEST);


        return centerPanel;
    }


    private JPanel createOperatorsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        JButton clear = new OperatorsJButton("C");
        JButton minus = new OperatorsJButton("-");
        JButton plus = new OperatorsJButton("+");
        JButton multiply = new OperatorsJButton("*");
        JButton divide = new OperatorsJButton("÷");
        JButton square = new OperatorsJButton("^");
        JButton sqrt = new OperatorsJButton("√");
        JButton percent = new OperatorsJButton("%");

        minus.addActionListener(new OperatorListener(inputField));
        plus.addActionListener(new OperatorListener(inputField));
        multiply.addActionListener(new OperatorListener(inputField));
        divide.addActionListener(new OperatorListener(inputField));
        square.addActionListener(new OperatorListener(inputField));
        sqrt.addActionListener(new OperatorListener(inputField));
        percent.addActionListener(new OperatorListener(inputField));
        clear.addActionListener(new ClearButtonActionListener(inputField));
        panel.add(minus);
        panel.add(plus);
        panel.add(multiply);
        panel.add(divide);
        panel.add(clear);
        panel.add(square);
        panel.add(sqrt);
        panel.add(percent);



        return panel;
    }


    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4, 3));
        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);

        }
        JButton equals = new OperatorsJButton("=");
        equals.addActionListener(new EqualButtonListener(inputField));
        digitsPanel.add(equals);
        JButton dot = new OperatorsJButton(".");
        dot.addActionListener(buttonListener);
        digitsPanel.add(dot);



        return digitsPanel;


    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        this.inputField = new JTextField();
        this.inputField.setEditable(false);
        top.add(this.inputField);
        inputField.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        inputField.setMargin(new Insets(10, 0, 10, 0));
        inputField.setBackground(new Color(255, 255, 255));
        this.inputField.setText("");
//        this.outputField = new JTextField();
//        this.outputField.setEditable(false);
//        top.add(this.outputField);
//        outputField.setFont(new Font("TimesRoman", Font.PLAIN, 25));
//        outputField.setMargin(new Insets(10, 0, 10, 0));
//        outputField.setBackground(new Color(255, 255, 255));
//        this.outputField.setText("123");
        return top;
    }
}

