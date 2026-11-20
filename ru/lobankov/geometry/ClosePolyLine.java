package ru.lobankov.geometry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ClosePolyLine<T extends Point> extends PolyLine<T> implements Iterable<T>{

    @SafeVarargs
    public ClosePolyLine(T... points) {
        super(points);
    }

    public ClosePolyLine(List<T> points) {
        super(points);
    }

    public ClosePolyLine(PolyLine<T> line) {
        super(line);
    }

    // Замкнутая линия после последней точки возвращается в первую.
    @Override
    protected List<T> path() {
        List<T> points = getPoints();
        if (points.size() < 2) {
            return points;
        }
        List<T> path = new ArrayList<>(points);
        path.add(points.getFirst());
        return path;
    }

    @Override
    public Iterator<T> iterator() {
        return iterator(0);
    }

    public Iterator<T> iterator(int i) {
        return new Itr(i%points.size());
    }

    private class Itr implements Iterator<T>{
        private final ListIterator<T> lstItr;

        public Itr(int i) {
            this.lstItr = getPoints().listIterator(i);
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public T next() {
            if (!lstItr.hasNext()){
                while(!lstItr.hasPrevious()){
                    lstItr.previous();
                }
            }
            return lstItr.next();
        }
    }
}
