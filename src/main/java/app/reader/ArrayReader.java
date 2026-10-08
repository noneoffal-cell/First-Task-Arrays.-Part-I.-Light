package app.reader;

import java.util.List;

import app.exception.FileReadingException;

public interface ArrayReader {

    List<String> read(String filePath) throws FileReadingException;
}
