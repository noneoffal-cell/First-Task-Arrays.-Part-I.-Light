package app.factory.impl;

import app.entity.IntArray;
import app.factory.ArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArrayFactory implements ArrayFactory<IntArray> {

    private static final Logger LOGGER =
            LogManager.getLogger(IntArrayFactory.class);

    @Override
    public IntArray create(int... values) {
        LOGGER.info("Created IntArray with {} values", values.length);
        return new IntArray(values);    // constructor from IntArray
    }
}
