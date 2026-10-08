package service;


import app.entity.IntArray;
import app.service.impl.InsertionSortServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortServiceImplTest {

    @Test
    void sortShouldReturnSortedArray() {
        // given
        InsertionSortServiceImpl service = new InsertionSortServiceImpl();
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
        InsertionSortServiceImpl service = new InsertionSortServiceImpl();
        IntArray array = new IntArray();
        int[] expected = {};

        // when
        IntArray result = service.sort(array);

        // then
        assertArrayEquals(expected, result.getArray());
    }
}
