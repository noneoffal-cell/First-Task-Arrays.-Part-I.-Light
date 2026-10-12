package app.factory.impl;

import app.entity.IntArray;
import app.factory.ArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArrayFactory implements ArrayFactory<IntArray> {

    private static final Logger LOGGER =
            LogManager.getLogger(IntArrayFactory.class);

    public IntArray create(int id, int... values) {
        LOGGER.info(
                "Creating IntArray with id {} and {} values",
                id,
                values.length
        );

        return new IntArray(id, values);
    }
}