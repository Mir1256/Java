package ru.lobankov.study;

public class GradeRule2To5 implements GradeRule{
    public static final GradeRule2To5 INSTANCE = new GradeRule2To5();
    private GradeRule2To5(){}


    @Override
    public boolean isValid() {
        return false;
    }
}
