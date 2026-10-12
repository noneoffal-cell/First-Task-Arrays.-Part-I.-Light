package app.entity;

import java.util.Arrays;

public class IntArray {

    private final int[] array;  // final prohibits reassignment
    private final int id;

    public int[] getArray() {
        return array.clone();
    }
    public int getId() {
        return id;
    }

    public IntArray(int... values) {
        this.id = 0;
        this.array = values.clone();
    }

    public IntArray(int id, int... values) {
        this.id = id;
        this.array = values.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntArray{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        IntArray intArray = (IntArray) object;
        return id == intArray.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
