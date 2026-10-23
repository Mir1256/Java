package tasker;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private Employee head;
    private List<Employee> team;


    public Department(String name, String head){
        this.name = name == null ? "" : name;
        this.head = new Employee(head);
        this.team = new ArrayList<>();
        if (head != null){
            team.add(this.head);
        }
    }

    public Department(String name){
        this(name,null);

    }
    public Department(){
        this(null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public List<Employee> getTeam() {
        return team;
    }

    public void setTeam(List<Employee> team) {
        this.team = team;
    }

    public String printAllWorkers(){
        String res = "В отделе работают: ";
        for (int i = 1; i < team.size() - 1; i++) {
            res += (team.get(i).getSelfName() +  ", ");
        }
        res += (team.getLast().getSelfName() +  ".");
        return res;
    }

    @Override
    public String toString() {
        return "Отдел" + name + "\n" + "Глава отдела" + head;
    }
}
