package ru.lobankov.study;

public class AllTrueGradeRule implements GradeRule{
    public static final AllTrueGradeRule INSTANCE = new AllTrueGradeRule();
    private AllTrueGradeRule(){}
    @Override
    public boolean isValid(Object value) {
        return false;
    }
}
