package ru.lobankov.exceptions;

public class DifferentDimensionsException extends RuntimeException {
    public DifferentDimensionsException(String message) {
        super(message);
    }

    public DifferentDimensionsException() {}
}
