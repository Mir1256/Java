package Java.tasker;

public class House {
    final int countFloor;
    public House(int countFloor){
        if (countFloor < 0) {
            throw new IllegalArgumentException();
        }
        this.countFloor = countFloor;
    }

    public String toString(){
        return countFloor%10 == 1 ? "Дом с "+countFloor+" этажом." : "Дом с "+countFloor+" этажами.";
    }
}
