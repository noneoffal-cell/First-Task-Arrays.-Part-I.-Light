package app.specification.impl;

import app.entity.IntArray;
import app.specification.ComparisonOperator;
import app.specification.Specification;

public class MinSpecification implements Specification<IntArray> {

    private final int expected;
    private final ComparisonOperator operator;

    public MinSpecification(int expected, ComparisonOperator operator) {
        this.expected = expected;
        this.operator = operator;
    }

    @Override
    public boolean isSatisfiedBy(IntArray item) {
        int[] values = item.getArray();

        if (values.length == 0) {
            return false;
        }

        int min = values[0];

        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }

        return operator.compare(min, expected);
    }
}