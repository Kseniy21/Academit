package main;

import comparator.AreaShapeComparator;
import comparator.PerimeterShapeComparator;
import shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(3);
        Square square2 = new Square(5);
        Rectangle rectangle1 = new Rectangle(2, 3);
        Rectangle rectangle2 = new Rectangle(4, 5);
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(5);
        Triangle triangle1 = new Triangle(1, 2, 4, 6, 7, 12);
        Triangle triangle2 = new Triangle(1, 1, 3, 5, 6, 7);

        Shape[] shapes = {square1, square2, rectangle1, rectangle2, circle1, circle2, triangle1, triangle2};

        Shape maxAreaShape = findMaxAreaShape(shapes);
        System.out.println("Фигура с максимальной площадью:  " + maxAreaShape.getClass() + " с параметрами: " + maxAreaShape.getHeight() + " и " + maxAreaShape.getWidth());
        System.out.println("Максимальная площадь = " + maxAreaShape.getArea());
        Shape secondMaxAreaShape = findSecondMaxPerimeterShape(shapes);
        System.out.println("Вторая по величине периметра фигура: " + secondMaxAreaShape.getClass() + " с параметрами: " + maxAreaShape.getHeight() + " и " + maxAreaShape.getWidth());
        System.out.println("Второй по величине периметр = " + secondMaxAreaShape.getPerimeter());
    }

    private static Shape findMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new AreaShapeComparator());
        return shapes[shapes.length - 1];
    }

    private static Shape findSecondMaxPerimeterShape(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterShapeComparator());
        return shapes[shapes.length - 2];
    }
}
