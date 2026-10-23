package ru.lobankov.buildings;

public class House {
    private final int countFloor;
    public House(int countFloor){
        if (countFloor < 1) {
            throw new IllegalArgumentException("Count of floors must be positive");
        }
        this.countFloor = countFloor;
    }

    public String toString(){
        return countFloor%10 == 1 && countFloor%100 != 11 ? "Дом с "+countFloor+" этажом." : "Дом с "+countFloor+" этажами.";
    }
}
