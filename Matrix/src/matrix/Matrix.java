package matrix;

import vector.Vector;

public class Matrix {
    private Vector[] rows;

    private Matrix(int rowsCount, int columnsCount) {
        if (rowsCount == 0 || columnsCount == 0) {
            throw new IllegalArgumentException("Матрица не может иметь нулевые размеры");
        }

        this.rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i] = new Vector(columnsCount);
        }
    }

    private Matrix(Matrix matrix) {
        this(matrix.rows);
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Матрица не может иметь нулевые размеры");
        }

        this.rows = new Vector[array.length];
        int rowLength = 0;
        for (double[] element : array) {
            rowLength = Math.max(rowLength, element.length);
        }
        for (int i = 0; i < array.length; i++) {
            this.rows[i] = new Vector(rowLength, array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Матрица не может иметь нулевые размеры");
        }

        int rowLength = 0;
        for (Vector vector : vectors) {
            if (vector.getSize() > rowLength) {
                rowLength = vector.getSize();
            }
        }
        this.rows = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            this.rows[i] = new Vector(rowLength, vectors[i]);
        }
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getVectorRowByIndex(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Индекс указан неверно");
        }
        return new Vector(rows[index]);
    }

    public void setVectorRowByIndex(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Индекс указан неверно");
        }
        rows[index] = new Vector(vector);
    }

    public Vector getVectorColumnByIndex(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException("Индекс указан неверно");
        }
        Vector vector = new Vector(getRowsCount());
        for (int i = 0; i < getRowsCount(); i++) {
            vector.setComponents(i, this.rows[i].getComponents(index));
        }
        return vector;
    }

    public void transpose() {
        Vector[] matrix = new Vector[this.getColumnsCount()];
        for (int i = 0; i < this.getColumnsCount(); i++) {
            matrix[i] = this.getVectorColumnByIndex(i);
        }
        this.rows = matrix;
    }

    public Matrix multiplicationScalar(int scalar) {
        for (Vector element : this.rows) {
            element.multiplicationScalar(scalar);
        }
        return this;
    }

    public static double calculationDeterminant(Matrix matrix) {
        if (matrix.getRowsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Для вычисления определителя матрица должна быть квадратной");
        }

        if (matrix.getRowsCount() == 1) {
            return matrix.rows[0].getComponents(0);
        }
        if (matrix.getRowsCount() == 2) {
            return matrix.getVectorRowByIndex(0).getComponents(0) * matrix.getVectorRowByIndex(1).getComponents(1) - matrix.getVectorRowByIndex(1).getComponents(0) * matrix.getVectorRowByIndex(0).getComponents(1);
        } else {
            double result = 0;
            for (int i = 0; i < matrix.getRowsCount(); i++) {
                Matrix minor = new Matrix(matrix.getRowsCount() - 1, matrix.getRowsCount() - 1);
                for (int j = 1; j < matrix.getRowsCount(); j++) {
                    Vector minorNewRow = new Vector(matrix.getRowsCount() - 1);
                    int m = 0;
                    for (int n = 0; n < matrix.getRowsCount() - 1; n++) {
                        if (m == i) {
                            m++;
                        }
                        minorNewRow.setComponents(n, matrix.getVectorRowByIndex(j).getComponents(m));
                        m++;
                    }
                    minor.setVectorRowByIndex(j - 1, minorNewRow);
                }
                result += Math.pow((double) -1, i) * matrix.getVectorRowByIndex(0).getComponents(i) * calculationDeterminant(minor);
            }
            return result;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Vector element : rows) {
            sb.append(element.toString());
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public Vector multiplyMatrixByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Количество столбцов матрицы должно быть равно размерности вектора");
        }
        Vector v = new Vector(this.getRowsCount());
        for (int i = 0; i < this.getRowsCount(); i++) {
            v.setComponents(i, Vector.getScalarMultiply(this.rows[i], vector));
        }
        return v;
    }

    public Matrix additionMatrices(Matrix matrix) {
        if (matrix.getRowsCount() != this.getRowsCount() || matrix.getColumnsCount() != this.getColumnsCount()) {
            throw new IllegalArgumentException("Сложение возможно только для матриц одинаковой размерности");
        }

        for (int i = 0; i < getRowsCount(); i++) {
            this.rows[i].addVector(matrix.rows[i]);
        }
        return this;
    }

    public Matrix differenceMatrices(Matrix matrix) {
        if (matrix.getRowsCount() != this.getRowsCount() || matrix.getColumnsCount() != this.getColumnsCount()) {
            throw new IllegalArgumentException("Вычитание возможно только для матриц одинаковой размерности");
        }

        for (int i = 0; i < getRowsCount(); i++) {
            this.rows[i].differenceVector(matrix.rows[i]);
        }
        return this;
    }

    public static Matrix additionMatrices2(Matrix m1, Matrix m2) {
        if (m1.getRowsCount() != m2.getRowsCount() || m1.getColumnsCount() != m2.getColumnsCount()) {
            throw new IllegalArgumentException("Сложение возможно только для матриц одинаковой размерности");
        }
        Matrix matrix = new Matrix(m1);
        return matrix.additionMatrices(m2);
    }

    public static Matrix differenceMatrices2(Matrix m1, Matrix m2) {
        if (m1.getRowsCount() != m2.getRowsCount() || m1.getColumnsCount() != m2.getColumnsCount()) {
            throw new IllegalArgumentException("Вычитание возможно только для матриц одинаковой размерности");
        }
        Matrix matrix = new Matrix(m1);
        return matrix.differenceMatrices(m2);
    }

    public static Matrix multiplyMatrices(Matrix m1, Matrix m2) {
        if (m1.getColumnsCount() != m2.getRowsCount()) {
            throw new IllegalArgumentException("Количество столбцов одной матрицы должно быть равно количеству строк другой матрицы");
        }
        int rowsCount1 = m1.getRowsCount();
        int columnsCount2 = m2.getColumnsCount();
        Matrix resultMatrix = new Matrix(rowsCount1, columnsCount2);
        for (int i = 0; i < rowsCount1; i++) {
            for (int j = 0; j < columnsCount2; j++) {
                resultMatrix.rows[i].setComponents(j, Vector.getScalarMultiply(m1.rows[i], m2.getVectorColumnByIndex(j)));
            }
        }
        return resultMatrix;
    }
}
