package app.factory;

import app.entity.IntArray;
import app.factory.impl.IntArrayFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IntArrayFactoryTest {

    // given
    private static final int[] VALUES = {1, 2, 3};
    private static final int[] SINGLE_VALUE = {42};
    private static final int[] NEGATIVE_VALUES = {-5, 0, 7, -1};
    private static final int[] EMPTY_VALUES = {};

    private final ArrayFactory<IntArray> factory = new IntArrayFactory();

    @Test
    void createShouldReturnNotNullIntArray() {
        // given
        // when
        IntArray actual = factory.create(VALUES);

        // then
        assertNotNull(actual);
    }

    @Test
    void createShouldReturnIntArrayWithGivenValues() {
        // given
        // when
        IntArray actual = factory.create(VALUES);

        // then
        int[] actualValues = actual.getArray();
        assertArrayEquals(VALUES, actualValues);
    }

    @Test
    void createShouldReturnIntArrayWithSingleValue() {
        // given
        // when
        IntArray actual = factory.create(SINGLE_VALUE);

        // then
        int[] actualValues = actual.getArray();
        assertArrayEquals(SINGLE_VALUE, actualValues);
    }

    @Test
    void createShouldKeepNegativeValuesAndOrder() {
        // given
        // when
        IntArray actual = factory.create(NEGATIVE_VALUES);

        // then
        int[] actualValues = actual.getArray();
        assertArrayEquals(NEGATIVE_VALUES, actualValues);
    }

    @Test
    void createShouldReturnEmptyIntArrayForEmptyValues() {
        // given
        // when
        IntArray actual = factory.create(EMPTY_VALUES);

        // then
        int[] actualValues = actual.getArray();
        assertArrayEquals(EMPTY_VALUES, actualValues);
    }

    @Test
    void createShouldNotBeAffectedByChangesToOriginalArray() {
        // given
        int[] values = {1, 2, 3};

        // when
        IntArray actual = factory.create(values);
        values[0] = 99;

        // then
        assertArrayEquals(VALUES, actual.getArray());
    }
}