package app.factory;

import app.entity.IntArray;
import app.factory.impl.IntArrayFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IntArrayFactoryTest {

    // given
    private static final int ARRAY_ID = 1;
    private static final int[] VALUES = {1, 2, 3};
    private static final int[] SINGLE_VALUE = {42};
    private static final int[] NEGATIVE_VALUES = {-5, 0, 7, -1};
    private static final int[] EMPTY_VALUES = {};

    private final ArrayFactory<IntArray> factory = new IntArrayFactory();

    @Test
    void createShouldReturnNotNullIntArray() {
        // when
        IntArray actual = factory.create(ARRAY_ID, VALUES);

        // then
        assertNotNull(actual);
    }

    @Test
    void createShouldReturnIntArrayWithGivenValues() {
        // when
        IntArray actual = factory.create(ARRAY_ID, VALUES);

        // then
        assertArrayEquals(VALUES, actual.getArray());
    }

    @Test
    void createShouldReturnIntArrayWithSingleValue() {
        // when
        IntArray actual = factory.create(ARRAY_ID, SINGLE_VALUE);

        // then
        assertArrayEquals(SINGLE_VALUE, actual.getArray());
    }

    @Test
    void createShouldKeepNegativeValuesAndOrder() {
        // when
        IntArray actual = factory.create(ARRAY_ID, NEGATIVE_VALUES);

        // then
        assertArrayEquals(NEGATIVE_VALUES, actual.getArray());
    }

    @Test
    void createShouldReturnEmptyIntArrayForEmptyValues() {
        // when
        IntArray actual = factory.create(ARRAY_ID, EMPTY_VALUES);

        // then
        assertArrayEquals(EMPTY_VALUES, actual.getArray());
    }

    @Test
    void createShouldNotBeAffectedByChangesToOriginalArray() {
        // given
        int[] values = {1, 2, 3};

        // when
        IntArray actual = factory.create(ARRAY_ID, values);
        values[0] = 99;

        // then
        assertArrayEquals(VALUES, actual.getArray());
    }

    @Test
    void createShouldPreserveGivenId() {
        // when
        IntArray actual = factory.create(ARRAY_ID, VALUES);

        // then
        assertEquals(ARRAY_ID, actual.getId());
    }
}