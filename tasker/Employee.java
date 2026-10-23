package tasker;

import java.util.Objects;

public class Employee {
    private String selfName;
    private Department department;

    public Employee(String selfName, Department department) {
        this.selfName = selfName;
        this.department = department;
        this.department.getTeam().add(this);
    }

    public Employee(String selfName, String department) {
        this.selfName = selfName;
        this.department = new Department(department);
        this.department.getTeam().add(this);
    }

    public Employee(String selfName) {
        this.selfName = selfName;
        department = new Department();
    }
    public Employee(){}

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    @Override
    public String toString() {
        if (Objects.equals(selfName, department.getHead().selfName)) return selfName + " начальник отдела " + department.getName();
        return selfName + " работает в " + department.getName() + ", начальник которого " + department.getHead().selfName;
    }
}
