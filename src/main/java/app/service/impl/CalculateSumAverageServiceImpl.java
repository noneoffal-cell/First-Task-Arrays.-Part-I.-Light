package app.service.impl;

import app.entity.IntArray;
import app.service.CalculateSumAverageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalLong;

public class CalculateSumAverageServiceImpl implements CalculateSumAverageService {

    private static final Logger LOGGER =
            LogManager.getLogger(CalculateSumAverageServiceImpl.class);

    @Override
    public OptionalLong calculateSum(IntArray array) {
        LOGGER.info("Calculating the sum");
        int[] values = array.getArray();

        if (values.length == 0) {
            return OptionalLong.empty();
        }

        long sum = 0;

        for (int value : values) {
            sum += value;
        }

        LOGGER.info("Found the sum");
        return OptionalLong.of(sum);
    }

    @Override
    public OptionalDouble calculateAverage(IntArray array) {
        LOGGER.info("Calculating the average");
        int[] values = array.getArray();

        if (values.length == 0) {
            return OptionalDouble.empty();
        }

        long sum = 0;

        for (int value : values) {
            sum += value;
        }

        double average = (double) sum / values.length;

        LOGGER.info("Found the average");
        return OptionalDouble.of(average);
    }
}
