package ru.lobankov.study;

import ru.lobankov.checkers.CheckAllTrue;
import ru.lobankov.checkers.Checker;
import ru.lobankov.exceptions.InvalidGradeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.sort;

public class Student {
    private String selfName;
    private List<Integer> grades;
    private final Checker checker;

    public Student(String selfName,Checker checker, int... grades) throws InvalidGradeException {
        this.selfName = selfName;
        this.grades = new ArrayList<>();
        this.checker = checker == null? CheckAllTrue.INTSTANCE: checker;
        setGrades(grades);
    }
    public Student(Student student){
        this.selfName = student.selfName;
        this.checker = student.checker;
        this.grades = student.grades;
    }

    public Student(String name) throws IllegalAccessException {
        throw new IllegalAccessException();
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

    public void setGrades(List<Integer> grades) throws InvalidGradeException {
        for (Integer grade: grades){
            if (!checker.isCorrect(grade)) {
                throw new InvalidGradeException(grade);
            }
        }
        this.grades = new ArrayList<>(grades);
    }

    public void setGrades(int... grades) throws InvalidGradeException {
        for (int grade: grades){
            if (!checker.isCorrect(grade)) {
                throw new InvalidGradeException(grade);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Integer grade: grades){
            res.add(grade);
        }
        this.grades = res;
    }

    public void addGrade(int grade) throws InvalidGradeException {
        if (!checker.isCorrect(grade)) {
            throw new InvalidGradeException(grade);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        List<Integer> gradesCopy = new ArrayList<>(grades);
        List<Integer> studGradesCopy = new ArrayList<>(student.grades);
        sort(gradesCopy);
        sort(studGradesCopy);
        return (Objects.equals(selfName, student.selfName) && Objects.equals(gradesCopy,studGradesCopy));
    }

    @Override
    public int hashCode() {
        List<Integer> gradesCopy = new ArrayList<>(grades);
        sort(gradesCopy);
        return Objects.hash(selfName, gradesCopy);
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
