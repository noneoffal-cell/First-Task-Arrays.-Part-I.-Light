package app.specification.impl;

import app.entity.IntArray;
import app.specification.ComparisonOperator;
import app.specification.Specification;

public class SizeSpecification implements Specification<IntArray> {

    private final int expected;
    private final ComparisonOperator operator;

    public SizeSpecification(int expected, ComparisonOperator operator) {
        this.expected = expected;
        this.operator = operator;
    }

    @Override
    public boolean isSatisfiedBy(IntArray item) {
        int size = item.getArray().length;

        return operator.compare(size, expected);
    }
}