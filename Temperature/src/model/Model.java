package model;

public class Model {
    private double temperature;


    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void convertTemperature(double inTemperature, String inScale, String outScale) {
        switch (inScale) {
            case "Цельсий":
                if (outScale.equals("Кельвин")) {
                    temperature = inTemperature + 273.15;
                } else if (outScale.equals("Фаренгейт")) {
                    temperature = inTemperature * 1.8 + 32;
                }
                break;
            case "Кельвин":
                if (outScale.equals("Цельсий")) {
                    temperature = inTemperature - 273.15;
                } else if (outScale.equals("Фаренгейт")) {
                    temperature = (inTemperature - 273.15) * 1.8 + 32;
                }
                break;
            case "Фаренгейт":
                if (outScale.equals("Цельсий")) {
                    temperature = (inTemperature - 32) * 1.8;
                } else if (outScale.equals("Кельвин")) {
                    temperature = (inTemperature - 32) * 1.8 + 273.15;
                }
                break;
        }

        if (inScale.equals(outScale)) {
            temperature = inTemperature;
        }
    }
}
