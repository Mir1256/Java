package ru.lobankov.company;

public class Employee {
    private String selfName;
    Department department;

    public Employee(String selfName, Department department) {
        this.selfName = selfName == null ? "" : selfName;
        this.department = department == null ? Department.UNASSIGNED : department;
        this.department.addEmployee(this);
    }

    public Employee(String selfName, String department) {
        this.selfName = selfName == null ? "" : selfName;
        this.department = isBlank(department) ? Department.UNASSIGNED : new Department(department);
        this.department.addEmployee(this);
    }

    public Employee(String selfName) {
        this.selfName = selfName == null ? "" : selfName;
        department = Department.UNASSIGNED;
        department.addEmployee(this);
    }

    private boolean isBlank(String s){
        return s == null || s.isBlank();
    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName == null ? "" : selfName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department){
        Department newDepartment = department == null ? Department.UNASSIGNED : department;
        Department.transfer(this,this.department,newDepartment);
    }

    @Override
    public String toString() {
        if (department.getHead() == this) return selfName + " начальник отдела " + department.getName();
        if (department.getHead() == null) {
            return selfName + " работает в отделе " + department.getName();
        }
        return selfName + " работает в отделе " + department.getName() + ", начальник которого " + department.getHead().selfName;
    }
}
