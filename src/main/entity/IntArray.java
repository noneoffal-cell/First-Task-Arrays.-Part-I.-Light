package main.entity;

public class IntArray {

    private int[] array;

    public int[] getArray() {
        return array;
    }

    public IntArray(int... values) {
        this.array = values;
    }
}
