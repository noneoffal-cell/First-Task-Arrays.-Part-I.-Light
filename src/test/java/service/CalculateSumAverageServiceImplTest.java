package service;

import app.entity.IntArray;
import app.service.CalculateSumAverageService;
import app.service.impl.CalculateSumAverageServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculateSumAverageServiceTest {

    @Test
    void calculateSumShouldReturnSumOfValues() {
        // given
        CalculateSumAverageService service = new CalculateSumAverageServiceImpl();
        IntArray array = new IntArray(1, 2, 3, 4);

        // when
        OptionalLong result = service.calculateSum(array);

        // then
        assertEquals(OptionalInt.of(10), result);
    }

    @Test
    void calculateSumShouldReturnEmptyForEmptyArray() {
        // given
        CalculateSumAverageService service = new CalculateSumAverageServiceImpl();
        IntArray array = new IntArray();

        // when
        OptionalLong result = service.calculateSum(array);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    void calculateAverageShouldReturnAverageValue() {
        // given
        CalculateSumAverageService service = new CalculateSumAverageServiceImpl();
        IntArray array = new IntArray(2, 4, 6);

        // when
        OptionalDouble result = service.calculateAverage(array);

        // then
        assertEquals(OptionalDouble.of(4.0), result);
    }

    @Test
    void calculateAverageShouldReturnEmptyForEmptyArray() {
        // given
        CalculateSumAverageService service = new CalculateSumAverageServiceImpl();
        IntArray array = new IntArray();

        // when
        OptionalDouble result = service.calculateAverage(array);

        // then
        assertTrue(result.isEmpty());
    }
}
