package ru.lobankov.checkers;

public class CheckAnyEven implements Checker {
    @Override
    public boolean isCorrect(Number number) {
        return number.intValue() % 2 == 0;
    }
}
