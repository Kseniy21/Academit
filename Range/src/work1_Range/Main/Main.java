package work1_Range.Main;

import work1_Range.Range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(1, 10);
        Range range2 = new Range(7, 15);

        System.out.println("Длина первого диапазона = " + range1.getLength());
        System.out.println("Длина второго диапазона = " + range2.getLength());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        double inputNumber = scanner.nextDouble();
        System.out.println("Проверка принадлежности числа первому диапазону " + range1.isInside(inputNumber));
        System.out.println("Проверка принадлежности числа второму диапазону " + range2.isInside(inputNumber));

        Range intersectionRange = range1.getIntersection(range2);
        if (intersectionRange == null) {
            System.out.println("Пересечений массивов нет.");
        } else {
            System.out.println("Интервал пересечения массивов: от " + intersectionRange.getFrom() + " до " + intersectionRange.getTo());
        }

        Range[] unionRange = range1.getUnion(range2);
        if (unionRange.length == 1) {
            System.out.println("Объединенный интервал массивов: от " + unionRange[0].getFrom() + " до " + unionRange[0].getTo());
        } else {
            System.out.println("Объединенный интервал массивов: от " + unionRange[0].getFrom() + " до " + unionRange[0].getTo() + " и " + unionRange[1].getFrom() + " до " + unionRange[1].getTo());
        }

        Range[] differenceRange = range1.getDifference(range2);
        if (differenceRange.length == 1) {
            System.out.println("Разность интервалов: от " + differenceRange[0].getFrom() + " до " + differenceRange[0].getTo());
        } else if (differenceRange.length == 0) {
            System.out.println("Разность интервалов: null");
        } else {
            System.out.println("Разность интервалов: от " + differenceRange[0].getFrom() + " до " + differenceRange[0].getTo() + " и " + differenceRange[1].getFrom() + " до " + differenceRange[1].getTo());
        }
    }
}
