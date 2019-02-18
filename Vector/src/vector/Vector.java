package vector;

import java.util.Arrays;

public class Vector {
    private double[] componentsVector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Вектор не может иметь нулевую или отрицательную длину");
        }
        this.componentsVector = new double[n];
    }

    private Vector(Vector vector) {
        this.componentsVector = Arrays.copyOf(vector.componentsVector, vector.componentsVector.length);
    }

    public Vector(double[] vector) {
        if (vector.length <= 0) {
            throw new IllegalArgumentException("Длина вектора не может быьт нулевой или отрицательной");
        }
        this.componentsVector = Arrays.copyOf(vector, vector.length);
    }

    public Vector(int n, double[] vector) {
        if (n <= 0) {
            throw new IllegalArgumentException("Вектор не может иметь нулевую или отрицательную длину");
        }
        this.componentsVector = Arrays.copyOf(vector, n);
    }

    public int getSize() {
        return this.componentsVector.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (double element : componentsVector) {
            sb.append(element).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }

    public Vector addVector(Vector addVector) {
        if (componentsVector.length < addVector.componentsVector.length) {
            this.componentsVector = Arrays.copyOf(componentsVector, addVector.componentsVector.length);
        }
        for (int i = 0; i < addVector.getSize(); i++) {
            this.componentsVector[i] += addVector.componentsVector[i];
        }
        return this;
    }

    public Vector differenceVector(Vector difVector) {
        if (componentsVector.length < difVector.componentsVector.length) {
            this.componentsVector = Arrays.copyOf(componentsVector, difVector.componentsVector.length);
        }
        for (int i = 0; i < difVector.getSize(); i++) {
            this.componentsVector[i] += difVector.componentsVector[i];
        }
        return this;
    }

    public Vector multiplicationScalarVector(int scalar) {
        for (int i = 0; i < componentsVector.length; i++) {
            this.componentsVector[i] *= scalar;
        }
        return this;
    }

    public Vector turnVector() {
        multiplicationScalarVector(-1);
        return this;
    }

    public double getLengthVector() {
        double length = 0;
        for (double element : componentsVector) {
            length += Math.sqrt(Math.pow(element, 2));
        }
        return length;
    }

    public void setComponentsVector(int index, double number) {
        componentsVector[index] = number;
    }

    public double getComponentsVector(int index) {
        return componentsVector[index];
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
        if (componentsVector.length == vector.componentsVector.length) {
            for (int i = 0; i < componentsVector.length; i++) {
                if (componentsVector[i] != vector.componentsVector[i]) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 1;
        int result = 5;
        result = result * prime + Double.hashCode(componentsVector.length);
        return result;
    }

    public static Vector getSumVectors(Vector v1, Vector v2) {
        Vector sumVector = new Vector(v1);
        return sumVector.addVector(v2);
    }

    public static Vector getDifferenceVectors(Vector v1, Vector v2) {
        Vector differenceVector = new Vector(v1);
        return differenceVector.differenceVector(v2);
    }

    public static double getScalarMultiplyVectors(Vector v1, Vector v2) {
        double ScalarMultiplyVector = 0;
        int MinLengthVectors = Math.min(v1.getSize(), v2.getSize());
        for (int i = 0; i < MinLengthVectors; i++) {
            ScalarMultiplyVector += v1.componentsVector[i] * v2.componentsVector[i];
        }
        return ScalarMultiplyVector;
    }
}
