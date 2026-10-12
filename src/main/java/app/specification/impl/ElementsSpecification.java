package app.specification.impl;

import app.entity.IntArray;
import app.specification.Specification;

import java.util.Arrays;

public class ElementsSpecification implements Specification<IntArray> {

    private final int[] expectedValues;

    public ElementsSpecification(int... expectedValues) {
        this.expectedValues = expectedValues.clone();
    }

    @Override
    public boolean isSatisfiedBy(IntArray item) {
        return Arrays.equals(item.getArray(), expectedValues);
    }
}