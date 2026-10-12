package app.specification.impl;

import app.entity.IntArray;
import app.specification.ComparisonOperator;
import app.specification.Specification;

public class AverageSpecification implements Specification<IntArray> {

    private final double expected;
    private final ComparisonOperator operator;

    public AverageSpecification(
            double expected,
            ComparisonOperator operator
    ) {
        this.expected = expected;
        this.operator = operator;
    }

    @Override
    public boolean isSatisfiedBy(IntArray item) {
        int[] values = item.getArray();

        if (values.length == 0) {
            return false;
        }

        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        double average = (double) sum / values.length;

        return operator.compare(average, expected);
    }
}