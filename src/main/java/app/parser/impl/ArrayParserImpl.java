package app.parser.impl;

import app.exception.InvalidArrayDataException;
import app.parser.ArrayParse;
import app.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParse {

    private static final Logger LOGGER =
            LogManager.getLogger(ArrayParserImpl.class);


    private static final String SEPARATOR_REGEX = "[,;\\-]+";
    private static final String SPACE_REGEX = "\\s+";

    private final ArrayValidator arrayValidator;

    public ArrayParserImpl(ArrayValidator arrayValidator) {
        this.arrayValidator = arrayValidator;
    }

    @Override
    public int[] parse(String data) throws InvalidArrayDataException {
        LOGGER.info("Parsing array data: {}", data);
        LOGGER.info("Validating array data: {}", data);
        validateData(data);

        if (data.trim().isEmpty()) {
            LOGGER.info("Empty array data");
            return new int[0];
        }

        String normalizedData = data.replaceAll(SEPARATOR_REGEX, " ");
        String trimmedData = normalizedData.trim();
        String[] parts = trimmedData.split(SPACE_REGEX);

        LOGGER.info("Array parsed successfully");
        return createValues(parts);
    }

    private void validateData(String data) throws InvalidArrayDataException {
        boolean valid = arrayValidator.isValid(data);

        if (valid) {
            LOGGER.info("Array data is valid");
        } else {
            LOGGER.warn("Invalid array data: {}", data);
            throw new InvalidArrayDataException("Invalid array data: " + data);
        }
    }

    private int[] createValues(String[] parts) {
        int[] values = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i]);
        }

        return values;
    }
}
