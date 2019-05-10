package controller;

import model.Model;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(new Listener());
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double inTemperature = view.getInTemperature();
                String inScale = view.getInScale();
                String outScale = view.getOutScale();

                model.convertTemperature(inTemperature, inScale, outScale);
                view.setOutTemperature(model.getTemperature());
            } catch (NumberFormatException message) {
                view.showErrorMessage("Неверный формат значения температуры!");
            }
        }
    }
}
