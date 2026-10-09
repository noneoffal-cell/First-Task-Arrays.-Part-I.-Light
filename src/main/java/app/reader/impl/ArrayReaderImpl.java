package app.reader.impl;

import app.exception.FileReadingException;
import app.reader.ArrayReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReaderImpl implements ArrayReader {

    private static final Logger LOGGER =
            LogManager.getLogger(ArrayReaderImpl.class);

    @Override
    public List<String> read(String filePath) throws FileReadingException {
        Path path = Path.of(filePath);

        try {
            List<String> lines = Files.readAllLines(path);
            LOGGER.info("File read successfully: {}", filePath);
            return lines;
        } catch (IOException e) {
            LOGGER.error("Failed to read file: {}", filePath, e);
            throw new FileReadingException(
                    "Cannot read file: " + filePath, e);
        }
    }
}
