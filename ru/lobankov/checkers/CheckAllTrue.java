package ru.lobankov.checkers;

public class CheckAllTrue implements Checker{
    public static final CheckAllTrue INTSTANCE = new CheckAllTrue();

    private CheckAllTrue() {}

    @Override
    public boolean isCorrect(Number number) {
        return true;
    }
}
