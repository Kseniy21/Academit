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
        int rowLength = 0;
        for (double[] element : array) {
            rowLength = Math.max(rowLength, element.length);
        }

        if (array.length == 0 || rowLength == 0) {
            throw new IllegalArgumentException("Матрица не может иметь нулевые размеры");
        }

        this.rows = new Vector[array.length];
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

    public Vector getRowByIndex(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Индекс указан неверно");
        }
        return new Vector(rows[index]);
    }

    public void setRowByIndex(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Индекс указан неверно");
        }
        rows[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException("Индекс указан неверно");
        }
        Vector vector = new Vector(getRowsCount());
        for (int i = 0; i < getRowsCount(); i++) {
            vector.setComponent(i, this.rows[i].getComponent(index));
        }
        return vector;
    }

    public void transpose() {
        Vector[] matrix = new Vector[this.getColumnsCount()];
        for (int i = 0; i < this.getColumnsCount(); i++) {
            matrix[i] = this.getColumnByIndex(i);
        }
        this.rows = matrix;
    }

    public Matrix multiplicationScalar(int scalar) {
        for (Vector element : this.rows) {
            element.multiplicationScalar(scalar);
        }
        return this;
    }

    public double calculateDeterminant() {
        if (this.getRowsCount() != this.getColumnsCount()) {
            throw new IllegalArgumentException("Для вычисления определителя матрица должна быть квадратной");
        }

        if (this.getRowsCount() == 1) {
            return this.rows[0].getComponent(0);
        }
        if (this.getRowsCount() == 2) {
            return this.rows[0].getComponent(0) * this.rows[1].getComponent(1)
                    - this.rows[1].getComponent(0) * this.rows[0].getComponent(1);
        }
        double result = 0;
        for (int i = 0; i < getColumnsCount(); i++) {
            double[][] temp = new double[getRowsCount() - 1][getColumnsCount() - 1];
            for (int j = 1; j < getRowsCount(); j++) {
                int columnIndex = 0;
                for (int n = 0; n < getRowsCount(); n++) {
                    if (n == i) {
                        continue;
                    }
                    temp[j - 1][columnIndex] = this.rows[j].getComponent(n);
                    columnIndex++;
                }
            }
            result += Math.pow(-1, i) * this.rows[0].getComponent(i) * new Matrix(temp).calculateDeterminant();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Vector element : rows) {
            sb.append(element.toString());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Количество столбцов матрицы должно быть равно размерности вектора");
        }
        Vector v = new Vector(this.getRowsCount());
        for (int i = 0; i < this.getRowsCount(); i++) {
            v.setComponent(i, Vector.getScalarMultiply(this.rows[i], vector));
        }
        return v;
    }

    public Matrix addMatrices(Matrix matrix) {
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

    public static Matrix addMatrices(Matrix m1, Matrix m2) {
        if (m1.getRowsCount() != m2.getRowsCount() || m1.getColumnsCount() != m2.getColumnsCount()) {
            throw new IllegalArgumentException("Сложение возможно только для матриц одинаковой размерности");
        }
        Matrix matrix = new Matrix(m1);
        return matrix.addMatrices(m2);
    }

    public static Matrix differenceMatrices(Matrix m1, Matrix m2) {
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
                resultMatrix.rows[i].setComponent(j, Vector.getScalarMultiply(m1.rows[i], m2.getColumnByIndex(j)));
            }
        }
        return resultMatrix;
    }
}
