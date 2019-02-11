package shapes;

import java.util.Objects;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object c) {
        if (c == this) {
            return true;
        }

        if (c == null || c.getClass() != this.getClass()) {
            return false;
        }

        Circle circle = (Circle) c;

        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        int prime = 1;
        int result = 5;
        result = result * prime + Double.hashCode(radius);
        return result;
    }

    @Override
    public String toString() {
        return "Радиус = " + radius;
    }
}
