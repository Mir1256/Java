package tasker;

public class Edge {
    private City city;
    private int cost;

    public Edge(City city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.city.getName() + " за " + this.cost;
    }
}
