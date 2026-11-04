package ru.lobankov.containers;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private final List<T> items;

    public Stack(T... items) {
        this.items = new ArrayList<>(List.of(items));
    }

    public Stack(){
        this.items = new ArrayList<>();
    }

    public void push(T item){
        this.items.add(item);
    }
    public T pop(){
        return this.items.removeLast();
    }
    public T peak(){
        return this.items.getLast();
    }
}
