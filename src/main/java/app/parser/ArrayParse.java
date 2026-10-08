package app.parser;

import app.exception.InvalidArrayDataException;

public interface ArrayParse {

    int[] parse(String data) throws InvalidArrayDataException;
}

