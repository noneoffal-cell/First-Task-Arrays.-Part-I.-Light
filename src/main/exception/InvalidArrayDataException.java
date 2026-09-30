package main.exception;

    // Useful if we have invalid data in a file
public class InvalidArrayDataException extends Exception {

    public InvalidArrayDataException(String message) {
        super(message);
    }
}
