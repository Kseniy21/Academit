package shapes;

public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public boolean equals(Object r) {
        if (r == this) {
            return true;
        }

        if (r == null || r.getClass() != this.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) r;

        return height == rectangle.height && width == rectangle.width;
    }

    @Override
    public int hashCode() {
        int prime = 1;
        int result = 5;
        result = result * prime + Double.hashCode(height);
        result = result * prime + Double.hashCode(width);
        return result;
    }

    @Override
    public String toString() {
        return "Длина = " + height + "Ширина = " + width;
    }
}
