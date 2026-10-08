package app.entity;

public class IntArray {

    private int[] array;

    public int[] getArray() {
        return array.clone();
    }

    public IntArray(int... values) {
        this.array = values.clone();
    }
}
