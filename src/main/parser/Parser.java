package main.parser;

import main.exception.InvalidArrayDataException;
import main.validation.Validator;

public class Parser {

    private static final String SEPARATOR_REGEX = "[,;\\-]+";
    private static final String SPACE_REGEX = "\\s+";

    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public int[] parse(String data) throws InvalidArrayDataException {
        validateData(data);

        if (data.trim().isEmpty()) {
            return new int[0];
        }

        String normalizedData = data.replaceAll(SEPARATOR_REGEX, " ");
        String trimmedData = normalizedData.trim();
        String[] parts = trimmedData.split(SPACE_REGEX);

        return createValues(parts);
    }

    private void validateData(String data) throws InvalidArrayDataException {
        boolean valid = validator.isValid(data);

        if(valid) {
            return;
        } else {
            throw new InvalidArrayDataException("Invalid array data: " + data);
        }
    }

    private int[] createValues(String[] parts) {
        int[] values = new int[parts.length];

        for (int i = 0; i< parts.length; i++) {
            values[i] = Integer.parseInt(parts[i]);
        }

        return values;
    }
}
