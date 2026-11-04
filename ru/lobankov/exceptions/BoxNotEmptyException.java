package ru.lobankov.exceptions;

public class BoxNotEmptyException extends RuntimeException {
    public BoxNotEmptyException() {}
    public BoxNotEmptyException(String message) {
        super(message);
    }
}
