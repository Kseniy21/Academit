package vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Вектор не может иметь нулевую или отрицательную длину");
        }
        this.components = new double[n];
    }

    private Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] vector) {
        if (vector.length <= 0) {
            throw new IllegalArgumentException("Длина вектора не может быьт нулевой или отрицательной");
        }
        this.components = Arrays.copyOf(vector, vector.length);
    }

    public Vector(int n, double[] vector) {
        if (n <= 0) {
            throw new IllegalArgumentException("Вектор не может иметь нулевую или отрицательную длину");
        }
        this.components = Arrays.copyOf(vector, n);
    }

    public int getSize() {
        return this.components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (double element : components) {
            sb.append(element).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }

    public Vector addVector(Vector addVector) {
        if (components.length < addVector.components.length) {
            this.components = Arrays.copyOf(components, addVector.components.length);
        }
        for (int i = 0; i < addVector.getSize(); i++) {
            this.components[i] += addVector.components[i];
        }
        return this;
    }

    public Vector differenceVector(Vector difVector) {
        if (components.length < difVector.components.length) {
            this.components = Arrays.copyOf(components, difVector.components.length);
        }
        for (int i = 0; i < difVector.getSize(); i++) {
            this.components[i] += difVector.components[i];
        }
        return this;
    }

    public Vector multiplicationScalar(int scalar) {
        for (int i = 0; i < components.length; i++) {
            this.components[i] *= scalar;
        }
        return this;
    }

    public Vector turn() {
        multiplicationScalar(-1);
        return this;
    }

    public double getLength() {
        double length = 0;
        for (double element : components) {
            length += Math.pow(element, 2);
        }
        return Math.sqrt(length);
    }

    public void setComponents(int index, double number) {
        components[index] = number;
    }

    public double getComponents(int index) {
        return components[index];
    }

    @Override
    public boolean equals(Object v) {
        if (v == this) {
            return true;
        }

        if (v == null || v.getClass() != this.getClass()) {
            return false;
        }

        Vector vector = (Vector) v;
        if (components.length != vector.components.length) {
            return false;
        }
        for (int i = 0; i < components.length; i++) {
            if (components[i] != vector.components[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(components.length);
    }

    public static Vector getSum(Vector v1, Vector v2) {
        Vector sumVector = new Vector(v1);
        return sumVector.addVector(v2);
    }

    public static Vector getDifference(Vector v1, Vector v2) {
        Vector differenceVector = new Vector(v1);
        return differenceVector.differenceVector(v2);
    }

    public static double getScalarMultiply(Vector v1, Vector v2) {
        double scalarMultiplyVector = 0;
        int MinLengthVectors = Math.min(v1.getSize(), v2.getSize());
        for (int i = 0; i < MinLengthVectors; i++) {
            scalarMultiplyVector += v1.components[i] * v2.components[i];
        }
        return scalarMultiplyVector;
    }
}
