package app.validator;

import app.validator.impl.ArrayValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayValidatorImplTest {

    private static final String COMMA_SEPARATED = "1, 2, 3";
    private static final String SEMICOLON_SEPARATED = "1; 2; 3";
    private static final String DASH_SEPARATED = "1 - 2 - 3";
    private static final String SPACE_SEPARATED = "1 2 3";
    private static final String EMPTY_DATA = "";
    private static final String WHITESPACE_DATA = "     ";
    private static final String NULL_DATA = null;
    private static final String LETTER_INSIDE_NUMBER = "1y1 21 32";
    private static final String LETTER_AS_ELEMENT = "1, 2, x, 4";
    private static final String MIXED_INVALID_DATA = "1, 2, x3, 6..5, 77";

    private final ArrayValidator validator = new ArrayValidatorImpl();

    @Test
    void isValidShouldReturnTrueForCommaSeparatedData() {
        // given
        // when
        boolean actual = validator.isValid(COMMA_SEPARATED);

        // then
        assertTrue(actual);
    }

    @Test
    void isValidShouldReturnTrueForSemicolonSeparatedData() {
        // given
        // when
        boolean actual = validator.isValid(SEMICOLON_SEPARATED);

        // then
        assertTrue(actual);
    }

    @Test
    void isValidShouldReturnTrueForDashSeparatedData() {
        // given
        // when
        boolean actual = validator.isValid(DASH_SEPARATED);

        // then
        assertTrue(actual);
    }

    @Test
    void isValidShouldReturnTrueForSpaceSeparatedData() {
        // given
        // when
        boolean actual = validator.isValid(SPACE_SEPARATED);

        // then
        assertTrue(actual);
    }

    @Test
    void isValidShouldReturnTrueForEmptyData() {
        // given
        // when
        boolean actual = validator.isValid(EMPTY_DATA);

        // then
        assertTrue(actual);
    }

    @Test
    void isValidShouldReturnTrueForWhitespaceData() {
        // given
        // when
        boolean actual = validator.isValid(WHITESPACE_DATA);

        // then
        assertTrue(actual);
    }

    @Test
    void isValidShouldReturnFalseForNullData() {
        // given
        // when
        boolean actual = validator.isValid(NULL_DATA);

        // then
        assertFalse(actual);
    }

    @Test
    void isValidShouldReturnFalseForLetterInsideNumber() {
        // given
        // when
        boolean actual = validator.isValid(LETTER_INSIDE_NUMBER);

        // then
        assertFalse(actual);
    }

    @Test
    void isValidShouldReturnFalseForLetterAsElement() {
        // given
        // when
        boolean actual = validator.isValid(LETTER_AS_ELEMENT);

        // then
        assertFalse(actual);
    }

    @Test
    void isValidShouldReturnFalseForMixedInvalidData() {
        // given
        // when
        boolean actual = validator.isValid(MIXED_INVALID_DATA);

        // then
        assertFalse(actual);
    }
}