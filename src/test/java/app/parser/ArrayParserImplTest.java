package app.parser;

import app.exception.InvalidArrayDataException;
import app.parser.impl.ArrayParserImpl;
import app.validator.ArrayValidator;
import app.validator.impl.ArrayValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayParserImplTest {

    private static final String COMMA_DATA = "1, 2, 3, 4, 5";
    private static final String SEMICOLON_DATA = "1; 2; 3; 4; 5";
    private static final String DASH_DATA = "1 - 2 - 3 - 4 - 5";
    private static final String SPACE_DATA = "1 2 3 4 5";
    private static final String EMPTY_DATA = "";
    private static final String INVALID_DATA = "1, 2, abc, 4";

    private static final int[] EXPECTED_ARRAY = {1, 2, 3, 4, 5};

    private final ArrayValidator validator = new ArrayValidatorImpl();
    private final ArrayParse parser = new ArrayParserImpl(validator);

    @Test
    void parseShouldParseCommaSeparatedData()
            throws InvalidArrayDataException {
        // when
        int[] result = parser.parse(COMMA_DATA);

        // then
        assertArrayEquals(EXPECTED_ARRAY, result);
    }

    @Test
    void parseShouldParseSemicolonSeparatedData()
            throws InvalidArrayDataException {
        // when
        int[] result = parser.parse(SEMICOLON_DATA);

        // then
        assertArrayEquals(EXPECTED_ARRAY, result);
    }

    @Test
    void parseShouldParseDashSeparatedData()
            throws InvalidArrayDataException {
        // when
        int[] result = parser.parse(DASH_DATA);

        // then
        assertArrayEquals(EXPECTED_ARRAY, result);
    }

    @Test
    void parseShouldParseSpaceSeparatedData()
            throws InvalidArrayDataException {
        // when
        int[] result = parser.parse(SPACE_DATA);

        // then
        assertArrayEquals(EXPECTED_ARRAY, result);
    }

    @Test
    void parseShouldReturnEmptyArrayForEmptyData()
            throws InvalidArrayDataException {
        // when
        int[] result = parser.parse(EMPTY_DATA);

        // then
        assertArrayEquals(new int[0], result);
    }

    @Test
    void parseShouldThrowExceptionForInvalidData() {
        // when
        // then
        assertThrows(
                InvalidArrayDataException.class,
                () -> parser.parse(INVALID_DATA));
    }
}

