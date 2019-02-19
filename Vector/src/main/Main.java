package main;

import vector.Vector;


public class Main {
    public static void main(String[] args) {
        double[] array1 = new double[]{1, 2, 3, 4, 5, 6, 7};
        double[] array2 = new double[]{5, 4, 3, 2, 1};

        try {
            Vector v1 = new Vector(array1);
            Vector v2 = new Vector(array2);
            System.out.println("Размер первого вектора = " + v1.getSize());
            System.out.println("Размер второго вектора = " + v2.getSize());

            Vector addVector = new Vector(array1);
            System.out.println("Результат прибавления к вектору другого вектора:" + addVector.addVector(v2));

            Vector diffVector = new Vector(array1);
            System.out.println("Результат вычитания из вектора другого вектора:" + diffVector.differenceVector(v2));

            Vector multiScalarVector = new Vector(array1);
            System.out.println("Результат умножения вектора на скаляр:" + multiScalarVector.multiplicationScalar(7));

            Vector turnVector = new Vector(array1);
            System.out.println("Результат разворота вектора:" + turnVector.turn());

            Vector vectorLength = new Vector(array1);
            System.out.println("Длина первого вектора:" + vectorLength.getLength());
            Vector vectorLength2 = new Vector(array2);
            System.out.println("Длина второго вектора:" + vectorLength2.getLength());

            Vector componentVector = new Vector(array1);
            componentVector.setComponents(3, 21);
            System.out.println("Получение компоненты вектора по индексу:" + componentVector.getComponents(3));

            System.out.println("Сумма двух векторов:" + Vector.getSum(v1, v2));
            System.out.println("Разность двух векторов:" + Vector.getDifference(v1, v2));
            System.out.println("Умножение двух векторов на скаляр:" + Vector.getScalarMultiply(v1, v2));
        } catch (IllegalArgumentException e) {
            System.out.println("Сообщение об ошибке" + e.getMessage());
        }
    }
}
