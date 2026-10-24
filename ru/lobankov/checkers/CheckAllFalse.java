package ru.lobankov.checkers;

public class CheckAllFalse implements Checker{
    public static final CheckAllFalse INSTANCE = new CheckAllFalse();

    private CheckAllFalse() {}

    @Override
    public boolean isCorrect(Number number) {
        return false;
    }
}
