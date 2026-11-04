package ru.lobankov.containers;

import ru.lobankov.exceptions.BoxNotEmptyException;

public class GeneralizedBox<T> {
    private T object;

    public GeneralizedBox(T object) {
        this.object = object;
    }

    public T getObject() {
        T res = object;
        object = null;
        return res;
    }

    public void putObject(T object) {
        if (this.object != null) {
            throw new BoxNotEmptyException();
        }
        this.object = object;
    }

    public boolean isEmpty(){
        return object==null;
    }

    @Override
    public String toString() {
        return "object = " + object;
    }
}
