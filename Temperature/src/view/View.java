package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JLabel textLabel = new JLabel("Введите значение: ");
    private JTextField textField = new JTextField(10);
    private JTextField textFieldResult = new JTextField(10);
    private JButton resultField = new JButton("Результат");
    private JRadioButton button1 = new JRadioButton("Цельсий");
    private JRadioButton button2 = new JRadioButton("Кельвин");
    private JRadioButton button3 = new JRadioButton("Фаренгейт");
    private JRadioButton button4 = new JRadioButton("Цельсий");
    private JRadioButton button5 = new JRadioButton("Кельвин");
    private JRadioButton button6 = new JRadioButton("Фаренгейт");

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JTextField getTextFieldResult() {
        return textFieldResult;
    }

    public void setTextFieldResult(JTextField textFieldResult) {
        this.textFieldResult = textFieldResult;
    }

    public JButton getResultField() {
        return resultField;
    }

    public void setResultField(JButton resultField) {
        this.resultField = resultField;
    }

    public JLabel getTextLabel() {
        return textLabel;
    }

    public void setTextLabel(JLabel textLabel) {
        this.textLabel = textLabel;
    }

    private JRadioButton getButton1() {
        return button1;
    }

    public void setButton1(JRadioButton button1) {
        this.button1 = button1;
    }

    private JRadioButton getButton2() {
        return button2;
    }

    public void setButton2(JRadioButton button2) {
        this.button2 = button2;
    }

    private JRadioButton getButton3() {
        return button3;
    }

    public void setButton3(JRadioButton button3) {
        this.button3 = button3;
    }

    private JRadioButton getButton4() {
        return button4;
    }

    public void setButton4(JRadioButton button4) {
        this.button4 = button4;
    }

    private JRadioButton getButton5() {
        return button5;
    }

    public void setButton5(JRadioButton button5) {
        this.button5 = button5;
    }

    private JRadioButton getButton6() {
        return button6;
    }

    public void setButton6(JRadioButton button6) {
        this.button6 = button6;
    }

    public View() {
        super("Конвертер температур");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        ButtonGroup bg = new ButtonGroup();
        bg.add(button1);
        bg.add(button2);
        bg.add(button3);
        add(button1, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(button2, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(button3, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(button4);
        bg2.add(button5);
        bg2.add(button6);
        add(button4, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(button5, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(button6, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));

        add(textLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));

        add(new JLabel("Перевод из:"), new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));

        add(textFieldResult, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));

        add(textField, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));

        add(new JLabel("Перевод в:"), new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));

        add(resultField, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
    }

    public double getInTemperature() {
        return Double.parseDouble(textField.getText());
    }

    public void setOutTemperature(double finalTemperature) {
        textFieldResult.setText(Double.toString(finalTemperature));
    }

    public String getInScale() {
        if (getButton1().isSelected()) {
            return getButton1().getText();
        } else if (getButton2().isSelected()) {
            return getButton2().getText();
        } else {
            return getButton3().getText();
        }
    }

    public String getOutScale() {
        if (getButton4().isSelected()) {
            return getButton4().getText();
        } else if (getButton5().isSelected()) {
            return getButton5().getText();
        } else {
            return getButton6().getText();
        }
    }

    public void addActionListener(ActionListener actionListener) {
        resultField.addActionListener(actionListener);
    }

    public void showErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}


