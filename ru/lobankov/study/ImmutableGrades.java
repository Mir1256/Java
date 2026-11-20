package ru.lobankov.study;

public interface ImmutableGrades<T> extends Excellentable, Averageable<T> {
    T averageGrade();
    boolean isExcellent();
}
