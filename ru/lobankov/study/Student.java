package ru.lobankov.study;

import ru.lobankov.checkers.CheckAllTrue;
import ru.lobankov.checkers.Checker;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String selfName;
    private List<Integer> grades;
    private final Checker checker;

    public Student(String selfName,Checker checker, int... grades){
        this.selfName = selfName;
        this.grades = new ArrayList<>();
        this.checker = checker == null? CheckAllTrue.INTSTANCE: checker;
        setGrades(grades);
    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void setGrades(List<Integer> grades) {
        for (Integer grade: grades){
            if (!checker.isCorrect(grade)) {
                throw new IllegalArgumentException();
            }
        }
        this.grades = new ArrayList<>(grades);
    }

    public void setGrades(int... grades){
        for (int grade: grades){
            if (!checker.isCorrect(grade)) {
                throw new IllegalArgumentException();
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Integer grade: grades){
            res.add(grade);
        }
        this.grades = res;
    }

    public void addGrade(int grade){
        if (!checker.isCorrect(grade)) {
            throw new IllegalArgumentException();
        }
        this.grades.add(grade);
    }

    public double getAverage(){
        double res = 0;

        if (grades.isEmpty())return  res;

        for (int grade:grades){
            res+=(double) grade;
        }
        return res / (double) grades.size();
    }

    public boolean isExcellent(){
        if (grades.isEmpty()) return false;
        for (int grade:grades){
            if (grade != 5) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (grades.isEmpty()){
            return selfName + ":" + " []";
        }

        String fullGrades = selfName + ":" + " [";
        for (int i = 0; i < grades.size() - 1; i++) {
            fullGrades += (Integer.toString(grades.get(i)) + ", ");
        }
        fullGrades += (Integer.toString(grades.getLast()) + "]");
        return fullGrades;
    }
}
