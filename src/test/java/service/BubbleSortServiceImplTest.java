package service;

import app.entity.IntArray;
import app.service.impl.BubbleSortServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortServiceImplTest {

    @Test
    void sortShouldReturnSortedArray() {
        // given
        BubbleSortServiceImpl service = new BubbleSortServiceImpl();
        IntArray array = new IntArray(5, 2, 8, 1);
        int[] expected = {1, 2, 5, 8};

        // when
        IntArray result = service.sort(array);

        // then
        assertArrayEquals(expected, result.getArray());
    }

    @Test
    void sortShouldReturnEmptyArrayForEmptyArray() {
        // given
        BubbleSortServiceImpl service = new BubbleSortServiceImpl();
        IntArray array = new IntArray();
        int[] expected = {};

        // when
        IntArray result = service.sort(array);

        // then
        assertArrayEquals(expected, result.getArray());
    }
}