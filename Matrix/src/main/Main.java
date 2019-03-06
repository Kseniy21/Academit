package main;

import matrix.Matrix;
import vector.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            Vector vector1 = new Vector(new double[]{1, 2, 3});
            Vector vector2 = new Vector(new double[]{1, 10, 20});
            Vector[] vectors = new Vector[]{vector1, vector2};
            Matrix matrix1 = new Matrix(vectors);
            System.out.println(matrix1);
            System.out.println("Количество строк матрицы: " + matrix1.getRowsCount());
            System.out.println("Количество столбцов: " + matrix1.getColumnsCount());

            Vector vector3 = new Vector(new double[]{1, 2, 3});
            Matrix matrix2 = new Matrix(vectors);
            matrix2.setRowByIndex(1, vector3);
            System.out.println(matrix2);
            System.out.println("Получение вектора-строки по индексу: " + matrix2.getRowByIndex(1));
            System.out.println("Получение вектора-столбца по индексу: " + matrix2.getColumnByIndex(1));

            System.out.println(matrix2);
            matrix2.transpose();
            System.out.println("Транспонирование матрицы:" + matrix2);
            System.out.println("Умножение матрицы на скаляр: " + matrix2.multiplicationScalar(2));

            Matrix matrix3 = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}});
            System.out.println(matrix3);
            System.out.println("Определитель матрицы =  " + matrix3.calculateDeterminant(matrix3));

            Vector vector4 = new Vector(new double[]{1, 2, 3});
            System.out.println("Умножение матрицы на вектор: " + matrix3.multiplyMatrixByVector(vector4));

            double[][] array1 = new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
            Matrix matrix4 = new Matrix(array1);
            double[][] array2 = new double[][]{{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};
            Matrix matrix5 = new Matrix(array2);
            System.out.println(matrix4);
            System.out.println(matrix5);
            System.out.println("Сложение матриц: " + matrix4.addMatrices(matrix5));
            Matrix matrix6 = new Matrix(array1);
            Matrix matrix7 = new Matrix(array2);
            System.out.println("Разность матриц: " + matrix6.differenceMatrices(matrix7));

            Matrix matrix8 = new Matrix(array1);
            Matrix matrix9 = new Matrix(array2);
            System.out.println("Сложение матриц2: " + Matrix.addMatrices2(matrix8, matrix9));
            System.out.println("Разность матриц2: " + Matrix.differenceMatrices2(matrix8, matrix9));
            System.out.println("Умножение матриц: " + Matrix.multiplyMatrices(matrix8, matrix9));
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
