package app.service;

import app.entity.IntArray;
import app.service.impl.FindMaxMinServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMaxMinServiceImplTest {

    private static final int[] VALUES = {5, 2, 8, 1, 9};
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;

    private final FindMaxMinService service =
            new FindMaxMinServiceImpl();

    @Test
    void findMaxShouldReturnMaximumValue() {
        // when
        OptionalInt result = service.findMax(new IntArray(VALUES));

        // then
        assertEquals(MAX_VALUE, result.getAsInt());
    }

    @Test
    void findMinShouldReturnMinimumValue() {
        // when
        OptionalInt result = service.findMin(new IntArray(VALUES));

        // then
        assertEquals(MIN_VALUE, result.getAsInt());
    }

    @Test
    void findMaxShouldReturnEmptyForEmptyArray() {
        // when
        OptionalInt result = service.findMax(new IntArray());

        // then
        assertEquals(OptionalInt.empty(), result);
    }

    @Test
    void findMinShouldReturnEmptyForEmptyArray() {
        // when
        OptionalInt result = service.findMin(new IntArray());

        // then
        assertEquals(OptionalInt.empty(), result);
    }
}