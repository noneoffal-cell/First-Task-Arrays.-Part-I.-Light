package app.specification.impl;

import app.entity.IntArray;
import app.specification.ComparisonOperator;
import app.specification.Specification;

public class SumSpecification implements Specification<IntArray> {

    private final long expected;
    private final ComparisonOperator operator;

    public SumSpecification(long expected, ComparisonOperator operator) {
        this.expected = expected;
        this.operator = operator;
    }

    @Override
    public boolean isSatisfiedBy(IntArray item) {
        int sum = 0;

        for (int value : item.getArray()) {
            sum += value;
        }

        return operator.compare(sum, expected);
    }
}