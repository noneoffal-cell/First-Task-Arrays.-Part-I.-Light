package app.service.impl;

import app.entity.IntArray;
import app.service.FindMaxMinService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.OptionalInt;

public class FindMaxMinServiceImpl implements FindMaxMinService {

    private static final Logger LOGGER =
            LogManager.getLogger(FindMaxMinServiceImpl.class);

    @Override
    public OptionalInt findMax(IntArray array) {
        LOGGER.info("Searching for max value");
        int[] values = array.getArray();

        if (values.length == 0) {
            return OptionalInt.empty();
        }

        int max = values[0];

        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }

        LOGGER.info("Found max value");
        return OptionalInt.of(max);
    }

    @Override
    public OptionalInt findMin(IntArray array) {
        LOGGER.info("Searching for min value");
        int[] values = array.getArray();

        if (values.length == 0) {
            return OptionalInt.empty();
        }

        int min = values[0];

        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }

        LOGGER.info("Found min value");
        return OptionalInt.of(min);
    }
}
