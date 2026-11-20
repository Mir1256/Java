package ru.lobankov.study;

public interface GradeRule<T> {
    boolean isValid(T value);
}
