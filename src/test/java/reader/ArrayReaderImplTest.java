package reader;


import app.exception.FileReadingException;
import app.reader.ArrayReader;
import app.reader.impl.ArrayReaderImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayReaderImplTest {

    @Test
    void readShouldReturnLinesFromFile() throws FileReadingException {
        // given
        ArrayReader reader = new ArrayReaderImpl();
        String filePath = "src/test/resources/test-array-data.txt";

        // when
        List<String> result = reader.read(filePath);

        // then
        assertEquals(2, result.size());
    }

    @Test
    void readShouldThrowExceptionForInvalidFilePath() {
        // given
        ArrayReader reader = new ArrayReaderImpl();
        String filePath = "invalid-file.txt";

        // when
        FileReadingException exception = assertThrows(
                FileReadingException.class,
                () -> reader.read(filePath));

        // then
        assertEquals(FileReadingException.class, exception.getClass());
    }
}
