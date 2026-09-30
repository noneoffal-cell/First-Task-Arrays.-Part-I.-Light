package main.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

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

    public boolean isValid(String data) {
        if (data != null) {
            return checkData(data);
        } else {
            return false;
        }
    }

        private boolean checkData(String data) {
            if (data.trim().isEmpty()) {
                return true;
            }

            Matcher matcher = VALID_DATA_PATTERN.matcher(data);
            return matcher.matches();
        }
    }

