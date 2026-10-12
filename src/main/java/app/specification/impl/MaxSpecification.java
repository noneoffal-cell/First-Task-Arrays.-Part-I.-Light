package app.specification.impl;

import app.entity.IntArray;
import app.specification.ComparisonOperator;
import app.specification.Specification;

public class MaxSpecification implements Specification<IntArray> {

    private final int expected;
    private final ComparisonOperator operator;

    public MaxSpecification(int expected, ComparisonOperator operator) {
        this.expected = expected;
        this.operator = operator;
    }

    @Override
    public boolean isSatisfiedBy(IntArray item) {
        int[] values = item.getArray();

        if (values.length == 0) {
            return false;
        }

        int max = values[0];

        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }

        return operator.compare(max, expected);
    }
}