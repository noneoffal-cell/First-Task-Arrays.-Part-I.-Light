package app.service;

import app.entity.IntArray;
import app.service.impl.InsertionSortServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortServiceImplTest {

    private static final int ARRAY_ID = 1;
    private static final int[] VALUES = {5, 2, 8, 1, 9};
    private static final int[] SORTED_VALUES = {1, 2, 5, 8, 9};

    private final ArraySortService service =
            new InsertionSortServiceImpl();

    @Test
    void sortShouldReturnSortedArray() {
        // when
        int[] result = service.sort(new IntArray(ARRAY_ID, VALUES));

        // then
        assertArrayEquals(SORTED_VALUES, result);
    }

    @Test
    void sortShouldReturnSameArrayWhenAlreadySorted() {
        // when
        int[] result = service.sort(
                new IntArray(ARRAY_ID, SORTED_VALUES)
        );

        // then
        assertArrayEquals(SORTED_VALUES, result);
    }

    @Test
    void sortShouldReturnEmptyArrayForEmptyArray() {
        // when
        int[] result = service.sort(new IntArray(ARRAY_ID));

        // then
        assertArrayEquals(new int[0], result);
    }
}