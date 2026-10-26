package ru.lobankov.exceptions;

public class InvalidGradeException extends RuntimeException{
    public InvalidGradeException(String name, Integer number) {
        super(name + "have grade" + number + "is not a valid");
    }
    public InvalidGradeException(String name) {
        super("Some thing gone wrong in "+name);
    }
    public InvalidGradeException() {
        super();
    }
}
