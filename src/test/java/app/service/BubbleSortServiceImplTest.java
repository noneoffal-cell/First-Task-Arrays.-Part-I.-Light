package app.service;

import app.entity.IntArray;
import app.service.impl.BubbleSortServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortServiceImplTest {

    private static final int[] VALUES = {5, 2, 8, 1, 9};
    private static final int[] SORTED_VALUES = {1, 2, 5, 8, 9};

    private final ArraySortService service =
            new BubbleSortServiceImpl();

    @Test
    void sortShouldReturnSortedArray() {
        // when
        IntArray result = service.sort(new IntArray(VALUES));

        // then
        assertArrayEquals(SORTED_VALUES, result.getArray());
    }

    @Test
    void sortShouldReturnSameArrayWhenAlreadySorted() {
        // when
        IntArray result = service.sort(new IntArray(SORTED_VALUES));

        // then
        assertArrayEquals(SORTED_VALUES, result.getArray());
    }

    @Test
    void sortShouldReturnEmptyArrayForEmptyArray() {
        // when
        IntArray result = service.sort(new IntArray());

        // then
        assertArrayEquals(new int[0], result.getArray());
    }
}