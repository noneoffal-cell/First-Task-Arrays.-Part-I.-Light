package app.entity;

public class IntArray {

    private final int[] array;  // final prohibits reassignment

    public int[] getArray() {
        return array.clone();
    }

    public IntArray(int... values) {
        this.array = values.clone();
    }
}
