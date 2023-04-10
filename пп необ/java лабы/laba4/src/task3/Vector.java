package task3;

import java.io.Serializable;
import java.util.Arrays;

public class Vector implements Serializable {
    private final double[] vector = new double[3];

    public Vector(double x, double y, double z) {
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
    }

    public double get(int i) {
        if (i > 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return vector[i];
    }

    public void set(int i, double e) {
        if (i > 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        vector[i] = e;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    public Vector toClone() {
        return new Vector(this.get(0), this.get(1), this.get(2));
    }
}
