package ru.lobankov.company;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private Employee head;
    private final List<Employee> team;
    public static final Department UNASSIGNED = new Department();

    public Department(){
        this(null, null);
    }

    public Department(String name){
        this(name,null);
    }

    public Department(String name, String head){
        this.name = name == null ? "" : name;
        this.team = new ArrayList<>();
        if (head != null){
            setHead(new Employee(head, this));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        if (this == UNASSIGNED) {
            return;
        }
        if (head != null){
            transfer(head, head.getDepartment(), this);
        }
        this.head = head;
    }

    public List<Employee> getTeam() {
        return new ArrayList<>(team);
    }

    static void transfer(Employee employee, Department from, Department to){
        if (from == to) return;
        if (employee == null) {
            throw new IllegalArgumentException("Null employee cant transfer");
        }
        from.removeEmployee(employee);
        if (from.getHead() == employee){
            from.head = null;
        }
        to.addEmployee(employee);
        employee.department = to;
    }

    void addEmployee(Employee employee){
        if (employee != null) {
            this.team.add(employee);
        }
    }

    void removeEmployee(Employee employee){
        if (employee != null) {
            this.team.remove(employee);
        }
    }

    public String printAllWorkers(){
        if (team.isEmpty()) {
            return "В отделе нет сотрудников.";
        }
        String res = "В отделе работают: ";
        for (int i = 0; i < team.size() - 1; i++) {
            res += (team.get(i).getSelfName() +  ", ");
        }
        res += (team.getLast().getSelfName() +  ".");
        return res;
    }

    @Override
    public String toString() {
        String headName = head == null ? "не назначен" : head.getSelfName();
        return "Отдел " + name + "\n" + "Глава отдела: " + headName;
    }
}
