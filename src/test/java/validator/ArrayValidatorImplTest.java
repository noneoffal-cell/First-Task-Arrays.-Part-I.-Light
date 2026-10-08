package validator;
import app.validator.ArrayValidator;
import app.validator.impl.ArrayValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayValidatorImplTest {

    @Test
    void isValidShouldReturnTrueForCommaSeparatedData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        String data = "1, 2, 3";

        // when
        boolean result = validator.isValid(data);

        // then
        assertTrue(result);
    }

    @Test
    void isValidShouldReturnTrueForSemicolonSeparatedData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        String data = "1; 2; 3";

        // when
        boolean result = validator.isValid(data);

        // then
        assertTrue(result);
    }

    @Test
    void isValidShouldReturnTrueForDashSeparatedData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        String data = "1 - 2 - 3";

        // when
        boolean result = validator.isValid(data);

        // then
        assertTrue(result);
    }

    @Test
    void isValidShouldReturnTrueForSpaceSeparatedData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        String data = "1 2 3";

        // when
        boolean result = validator.isValid(data);

        // then
        assertTrue(result);
    }

    @Test
    void isValidShouldReturnTrueForEmptyData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        String data = "";

        // when
        boolean result = validator.isValid(data);

        // then
        assertTrue(result);
    }

    @Test
    void isValidShouldReturnTrueForWhitespaceData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        String data = "     ";

        // when
        boolean result = validator.isValid(data);

        // then
        assertTrue(result);
    }

    @Test
    void isValidShouldReturnFalseForNullData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        String data = null;

        // when
        boolean result = validator.isValid(data);

        // then
        assertFalse(result);
    }

    @Test
    void isValidShouldReturnFalseForInvalidData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        String data = "1y1 21 32";

        // when
        boolean result = validator.isValid(data);

        // then
        assertFalse(result);
    }
}
