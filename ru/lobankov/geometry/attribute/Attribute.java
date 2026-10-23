package ru.lobankov.geometry.attribute;

public abstract class Attribute {
    private String name;
    private Object value;

    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
