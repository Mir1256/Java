package tasker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private String name;
    private List<Edge> edges;

    public City(String name, List<Edge> edges) {
        this.name = name;
        if (edges != null) {
            for (Edge edge: edges){
                addEdge(edge);
            }
        }else this.edges = new ArrayList<>();
    }

    public City(String name) {
        this(name,null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(City to, int cost){
        if (to == null) {
            throw new IllegalArgumentException("Нельзя добавить в несуществующий город");
        }
        for (Edge existing: this.edges){
            if (existing.getCity().getName().equals(to.name)){
                existing.setCost(cost);
                return;
            }
        }
        edges.add(new Edge(to,cost));
    }
    public void addEdge(Edge edge){
        if (edge == null) {
            throw new IllegalArgumentException("Нельзя добавлять несуществующее ребро");
        }
        City to = edge.getCity();
        if (to == null) {
            throw new IllegalArgumentException("У ребра не указан город назначения");
        }
        if (to.equals(this)) {
            throw new IllegalArgumentException("Нельзя добавить дорогу в самого себя");
        }

        for (Edge existing : this.edges) {
            if (existing.getCity().getName().equals(to.name)) {
                existing.setCost(edge.getCost());
                return;
            }
        }
        edges.add(edge);
    }

    public void removeEdge(City to) {
        if (to == null) {
            throw new IllegalArgumentException("Город не должен быть пустыим");
        }
        for (Edge edge : edges) {
            if (Objects.equals(edge.getCity().getName(), to.getName())) {
                edges.remove(edge);
            }
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (Edge edge : edges) {
            res+=(edge.toString() + ";\n");
        }
        return "Из города " + this.name + " можно добраться в города: \n" + res ;
    }
}
