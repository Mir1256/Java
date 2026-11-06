package ru.lobankov.geometry;

import java.util.List;

public class ClosePolyLine<T extends Point> extends PolygonalLine<T> implements Lengthable {
    public ClosePolyLine(T... points) {
        super(points);
    }

    public ClosePolyLine(List<T> points) {
        super(points);
    }

    public ClosePolyLine(PolygonalLine<T> line) {
        super(line);
    }

    @Override
    public double length() {
        if (normalizInator().size() > 2) {
            return super.length() + this.getPoints().getLast().dist(this.getPoints().getFirst());
        }
        return super.length();
    }
}
