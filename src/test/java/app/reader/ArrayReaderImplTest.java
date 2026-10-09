package app.reader;

import app.exception.FileReadingException;
import app.reader.impl.ArrayReaderImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayReaderImplTest {

    private static final String VALID_FILE_PATH =
            "src/test/resources/test-array-data.txt";
    private static final String INVALID_FILE_PATH =
            "invalid-file.txt";
    private static final int EXPECTED_LINES_COUNT = 2;

    private final ArrayReader reader = new ArrayReaderImpl();

    @Test
    void readShouldReturnLinesFromFile() throws FileReadingException {
        // when
        List<String> result = reader.read(VALID_FILE_PATH);

        // then
        assertEquals(EXPECTED_LINES_COUNT, result.size());
    }

    @Test
    void readShouldThrowExceptionForInvalidFilePath() {
        // when
        // then
        assertThrows(
                FileReadingException.class,
                () -> reader.read(INVALID_FILE_PATH));
    }
}

