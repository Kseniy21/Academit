package shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private static double getSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getPerimeter() {
        double side1 = getSide(x1, y1, x2, y2);
        double side2 = getSide(x2, y2, x3, y3);
        double side3 = getSide(x1, y3, x1, y3);

        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double side1 = getSide(x1, y1, x2, y2);
        double side2 = getSide(x2, y2, x3, y3);
        double side3 = getSide(x1, y1, x3, y3);
        double halfMeter = (side1 + side2 + side3) / 2;

        return Math.sqrt(halfMeter * (halfMeter - side1) * (halfMeter - side2) * (halfMeter - side3));
    }

    @Override
    public boolean equals(Object t) {
        if (t == this) {
            return true;
        }

        if (t == null || t.getClass() != this.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) t;

        return x1 == triangle.x1 && x2 == triangle.x2 && x3 == triangle.x3 && y1 == triangle.y1 && y2 == triangle.y2 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        int prime = 1;
        int result = 5;
        result = result * prime + Double.hashCode(x1);
        result = result * prime + Double.hashCode(x2);
        result = result * prime + Double.hashCode(x3);
        result = result * prime + Double.hashCode(y1);
        result = result * prime + Double.hashCode(y2);
        result = result * prime + Double.hashCode(y3);
        return result;
    }

    @Override
    public String toString() {
        return "Треугольник с параметрами: x1 = " + x1 + "x2 = " + x2 + "x3 = " + x3 + "y1 = " + y1 + "y2 = " + y2 + "y3 = " + y3;
    }
}
