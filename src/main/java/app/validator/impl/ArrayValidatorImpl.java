package app.validator.impl;


import app.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final Logger LOGGER =
            LogManager.getLogger(ArrayValidatorImpl.class);

    // ^ and $ — the start and the end of the ENTIRE string
    // s* — spaces at the beginning and the end. Zero or more
    // d+ — one or more digits
    // [,;-s] — separator
    // (s[]sd+) — space, separator, space, digit

    // Regex must be constant
    private static final String VALID_DATA_REGEX =
            "^\\s*\\d+(\\s*[,;\\-\\s]\\s*\\d+)*\\s*$";

    private static final Pattern VALID_DATA_PATTERN =
            Pattern.compile(VALID_DATA_REGEX);

    @Override
    public boolean isValid(String data) {

        if (data != null) {
            return checkData(data);
        } else {
            LOGGER.warn("Array data is null");
            return false;
        }
    }

    private boolean checkData(String data) {
        if (data.trim().isEmpty()) {
            LOGGER.warn("Array data is empty");
            return true;
        }

        Matcher matcher = VALID_DATA_PATTERN.matcher(data);
        return matcher.matches();
    }
}

