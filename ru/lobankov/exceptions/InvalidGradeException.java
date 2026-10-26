package ru.lobankov.exceptions;

public class InvalidGradeException extends Exception{
    public InvalidGradeException(Integer number) {
        super(number + "is not a valid");
    }
}
