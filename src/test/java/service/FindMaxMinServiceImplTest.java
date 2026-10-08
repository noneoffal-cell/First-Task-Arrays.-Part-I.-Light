package service;

import app.entity.IntArray;
import app.service.impl.FindMaxMinServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindMaxMinServiceImplTest {

    @Test
    void findMaxShouldReturnMaximumValue() {
        // given
        FindMaxMinServiceImpl service = new FindMaxMinServiceImpl();
        IntArray array = new IntArray(3, 7, 2, 5);

        // when
        OptionalInt result = service.findMax(array);

        // then
        assertEquals(OptionalInt.of(7), result);
    }

    @Test
    void findMinShouldReturnMinimumValue() {
        // given
        FindMaxMinServiceImpl service = new FindMaxMinServiceImpl();
        IntArray array = new IntArray(3, 7, 2, 5);

        // when
        OptionalInt result = service.findMin(array);

        // then
        assertEquals(OptionalInt.of(2), result);
    }

    @Test
    void findMaxShouldReturnEmptyForEmptyArray() {
        // given
        FindMaxMinServiceImpl service = new FindMaxMinServiceImpl();
        IntArray array = new IntArray();

        // when
        OptionalInt result = service.findMax(array);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    void findMinShouldReturnEmptyForEmptyArray() {
        // given
        FindMaxMinServiceImpl service = new FindMaxMinServiceImpl();
        IntArray array = new IntArray();

        // when
        OptionalInt result = service.findMin(array);

        // then
        assertTrue(result.isEmpty());
    }
}
