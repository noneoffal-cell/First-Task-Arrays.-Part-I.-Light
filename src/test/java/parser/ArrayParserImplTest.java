package parser;

import app.parser.impl.ArrayParserImpl;
import app.validator.impl.ArrayValidatorImpl;
import app.exception.InvalidArrayDataException;
import app.parser.ArrayParse;
import app.validator.ArrayValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayParserImplTest {

    @Test
    void parseShouldReturnValuesForCommaSeparatedData() throws InvalidArrayDataException {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParse parser = new ArrayParserImpl(validator);
        String data = "1, 2, 3";

        // when
        int[] result = parser.parse(data);

        // then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void parseShouldReturnValuesForDashSeparatedData() throws InvalidArrayDataException {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParse parser = new ArrayParserImpl(validator);
        String data = "1 - 2 - 3";

        // when
        int[] result = parser.parse(data);

        // then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void parseShouldReturnValuesForSpaceSeparatedData() throws InvalidArrayDataException {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParse parser = new ArrayParserImpl(validator);
        String data = "1 2 3";

        // when
        int[] result = parser.parse(data);

        // then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void parseShouldReturnEmptyArrayForEmptyData() throws InvalidArrayDataException {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParse parser = new ArrayParserImpl(validator);
        String data = "";

        // when
        int[] result = parser.parse(data);

        // then
        assertArrayEquals(new int[0], result);
    }

    @Test
    void parseShouldThrowExceptionForInvalidData() {
        // given
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParse parser = new ArrayParserImpl(validator);
        String data = "1x 2 3";

        // when
        org.junit.jupiter.api.function.Executable action =
                () -> parser.parse(data);

        // then
        assertThrows(InvalidArrayDataException.class, action);
    }
}
