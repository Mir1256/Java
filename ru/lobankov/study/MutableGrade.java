package ru.lobankov.study;

public interface MutableGrade<T> extends ImmutableGrades<T> {
    void add(T value);
    T remove();
}
