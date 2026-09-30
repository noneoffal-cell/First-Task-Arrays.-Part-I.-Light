package main.factory;

import main.entity.IntArray;

public class IntArrayFactory implements ArrayFactory<IntArray> {

    @Override
    public IntArray create(int... values) {
        return new IntArray(values);    // constructor from IntArray
    }
}
