package app.specification;

public enum ComparisonOperator {

    GREATER,
    LESS,
    EQUAL;

    public boolean compare(double actual, double expected) {
        if (this == GREATER) {
            return actual > expected;
        } else if (this == LESS) {
            return actual < expected;
        } else {
            return Double.compare(actual, expected) == 0;
        }
    }

}
