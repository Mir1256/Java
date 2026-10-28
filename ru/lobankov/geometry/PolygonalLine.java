package ru.lobankov.geometry;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonalLine implements Lengthable, PolyLineable{
    private List<Point> points;

    public PolygonalLine(Point... points){
        this(Arrays.asList(points));
    }

    public PolygonalLine(List<Point> points){
        this.points = new ArrayList<>();
        this.points.addAll(points);
    }

    public PolygonalLine(PolygonalLine line){
        this(line.points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point){
        this.points.add(point);
    }

    public List<Point> normalizInator() {
        if (points == null || points.size() < 3) {
            return points == null ? new ArrayList<>() : new ArrayList<>(points);
        }

        List<Point> result = new ArrayList<>();
        result.add(points.getFirst());

        for (int i = 1; i < points.size() - 1; i++) {
            Point prev = result.getLast();
            Point cur  = points.get(i);
            Point next = points.get(i + 1);

            if (!isCollinear(prev, cur, next)) {
                result.add(cur);
            }
        }

        result.add(points.getLast());
        return result;
    }

    private static boolean isCollinear(Point a, Point b, Point c) {
        long cross = (long) (b.getX() - a.getX()) * (c.getY() - b.getY())
                - (long) (b.getY() - a.getY()) * (c.getX() - b.getX());
        return cross == 0;
    }

    public double length(){
        List<Point> pointsList = normalizInator();
        double res = 0;
        for (int i = 0; i < pointsList.size() - 1; i++) {
            res += Point.distPoint2D(pointsList.get(i),pointsList.get(i+1));
        }
        return res;
    }

    private List<Point> path() {
        return getPolyline().getPoints();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof PolygonalLine other)) return false;
        return samePath(this.path(), other.path());
    }

    @Override
    public int hashCode() {
        List<Point> p = path();
        if (p.isEmpty()) return 0;
        if (p.size() == 1) return p.getFirst().hashCode();

        int hash = 0;
        for (int i = 0; i < p.size() - 1; i++) {
            int h1 = p.get(i).hashCode();
            int h2 = p.get(i + 1).hashCode();
            int segment = 31 * (h1 + h2) + h1 * h2;
            hash += mix(segment);
        }
        return hash;
    }

    private static boolean samePath(List<Point> a, List<Point> b) {
        if (a.size() != b.size()) return false;
        if (a.isEmpty()) return true;

        boolean cycleA = isCycle(a), cycleB = isCycle(b);
        if (cycleA != cycleB) return false;

        if (!cycleA) {
            return a.equals(b) || a.equals(b.reversed());
        }
        List<Point> ca = a.subList(0, a.size() - 1);
        List<Point> cb = b.subList(0, b.size() - 1);
        return isRotation(ca, cb) || isRotation(ca, cb.reversed());
    }

    private static boolean isCycle(List<Point> p) {
        return p.size() > 2 && p.getFirst().equals(p.getLast());
    }

    private static boolean isRotation(List<Point> a, List<Point> b) {
        int n = a.size();
        for (int shift = 0; shift < n; shift++) {
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) {
                ok = a.get(i).equals(b.get((i + shift) % n));
            }
            if (ok) return true;
        }
        return false;
    }

    private static int mix(int h) {
        h ^= h >>> 16; h *= 0x85ebca6b;
        h ^= h >>> 13; h *= 0xc2b2ae35;
        return h ^ (h >>> 16);
    }

    @Override
    public String toString() {
        String resValue = "Линия [";
        for (int i = 0; i < points.size() - 1; i++) {
            resValue += (points.get(i) + ", ");
        }
        resValue += (points.getLast() + "]");
        return resValue;
    }

    @Override
    public PolygonalLine getPolyline() {
        return this;
    }

    @Override
    public PolygonalLine clone(){
        try {
            PolygonalLine res = (PolygonalLine) super.clone();
            for (Point point:this.points){
                res.points.add(point.clone());
            }
            return res;
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }
}
