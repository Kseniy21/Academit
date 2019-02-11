package shapes;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public boolean equals(Object s) {
        if (s == this) {
            return true;
        }

        if (s == null || s.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) s;

        return side == square.side;
    }

    @Override
    public int hashCode() {
        int prime = 1;
        int result = 5;
        result = result * prime + Double.hashCode(side);
        return result;
    }

    @Override
    public String toString() {
        return "Сторона = " + side;
    }
}
