package app.service.impl;

import app.entity.IntArray;
import app.service.ArraySortService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSortServiceImpl implements ArraySortService {

    private static final Logger LOGGER =
            LogManager.getLogger(BubbleSortServiceImpl.class);

    @Override
    public IntArray sort(IntArray array) {
        LOGGER.info("Starting bubble sort");
        int[] values = array.getArray();

        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values [j + 1]) {
                    int temporary = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temporary;
                }
            }
        }

        LOGGER.info("Bubble sort completed");
        return new IntArray(values);
    }
}
