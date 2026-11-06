package ru.lobankov.geometry;

import java.util.ArrayList;
import java.util.List;

public class ClosePolyLine<T extends Point> extends PolyLine<T> {
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
}
