package ru.lobankov.containers;

public class Storage<T> {
    private final T object;

    public Storage(T object) {
        this.object = object;
    }

    public T getObject(T alternative) {
        return object == null? alternative : this.object;
    }
}
