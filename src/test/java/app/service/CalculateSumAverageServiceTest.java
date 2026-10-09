package app.service;

import app.entity.IntArray;
import app.service.impl.CalculateSumAverageServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculateSumAverageServiceTest {

    private static final int[] VALUES = {5, 2, 8, 1, 9};
    private static final long SUM = 25L;
    private static final double AVERAGE = 5.0;

    private final CalculateSumAverageService service =
            new CalculateSumAverageServiceImpl();

    @Test
    void calculateSumShouldReturnSumOfValues() {
        // when
        OptionalLong result = service.calculateSum(new IntArray(VALUES));

        // then
        assertTrue(result.isPresent());
        assertEquals(SUM, result.getAsLong());
    }

    @Test
    void calculateAverageShouldReturnAverageOfValues() {
        // when
        OptionalDouble result =
                service.calculateAverage(new IntArray(VALUES));

        // then
        assertTrue(result.isPresent());
        assertEquals(AVERAGE, result.getAsDouble());
    }

    @Test
    void calculateSumShouldReturnEmptyForEmptyArray() {
        // when
        OptionalLong result =
                service.calculateSum(new IntArray());

        // then
        assertEquals(OptionalLong.empty(), result);
    }

    @Test
    void calculateAverageShouldReturnEmptyForEmptyArray() {
        // when
        OptionalDouble result =
                service.calculateAverage(new IntArray());

        // then
        assertEquals(OptionalDouble.empty(), result);
    }
}