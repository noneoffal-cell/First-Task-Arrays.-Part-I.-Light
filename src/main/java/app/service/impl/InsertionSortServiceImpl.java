package app.service.impl;

import app.entity.IntArray;
import app.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSortServiceImpl implements ArraySortService {

    private static final Logger LOGGER =
            LogManager.getLogger(InsertionSortServiceImpl.class);

    @Override
    public IntArray sort(IntArray array) {
        LOGGER.info("Starting insertion sort");
        int[] values = array.getArray();

        for (int i = 1; i < values.length; i++) {
            int current = values[i];
            int j = i - 1;

            while (j >= 0 && values[j] > current) {
                values[j + 1] = values[j];
                j--;
            }

            values[j + 1] = current;
        }

        LOGGER.info("Insertion sort completed");
        return new IntArray(values);
    }
}
