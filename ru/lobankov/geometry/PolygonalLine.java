package ru.lobankov.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonalLine<T extends Point> implements Lengthable, PolyLineable{
    private List<T> points;

    @SafeVarargs
    public PolygonalLine(T... points){
        this((Arrays.asList(points)));
    }

    public PolygonalLine(List<T> points){
        this.points = new ArrayList<>();
        this.points.addAll(points);
    }

    public PolygonalLine(PolygonalLine<T> line){
        this(line.points);
    }

    private List<Point> toPoint(List<T> points){
        List<Point> res = new ArrayList<>();
        for(T point: points){
            res.add(new Point(point.getX(),point.getY()));
        }
        return res;
    }

    private List<Point3D> toPoint3D(List<T> points){
        List<Point3D> res = new ArrayList<>();
        for(T point: points){
            if (point.getClass() != Point3D.class){
                res.add(new Point3D(point.getX(),point.getY(), 0));
            }
            res.add((Point3D) point.clone());
        }
        return res;
    }

    public List<T> getPoints() {
        return points;
    }

    public void setPoints(List<T> points) {
        this.points = points;
    }

    public void addPoint(T point){
        this.points.add(point);
    }

    public List<T> normalizInator() {
        if (points == null || points.size() < 3) {
            return points == null ? new ArrayList<>() : new ArrayList<>(points);
        }

        List<T> result = new ArrayList<>();
        result.add(points.getFirst());

        for (int i = 1; i < points.size() - 1; i++) {
            T prev = result.getLast();
            T cur  = points.get(i);
            T next = points.get(i + 1);

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

    @Override
    public double length() {
        return 0;
    }

    @Override
    public PolygonalLine getPolyline() {
        return null;
    }
//
//    public double length(){
//        List<Point> pointsList = normalizInator();
//        double res = 0;
//        for (int i = 0; i < pointsList.size() - 1; i++) {
//            res += pointsList.get(i).dist(pointsList.get(i+1));
//        }
//        return res;
//    }
//
//    private List<T> path() {
//        return getPolyline().getPoints();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null) return false;
//        if (!(obj instanceof PolygonalLine other)) return false;
//        return samePath(this.path(), other.path());
//    }
//
//    @Override
//    public int hashCode() {
//        List<Point> p = path();
//        if (p.isEmpty()) return 0;
//        if (p.size() == 1) return p.getFirst().hashCode();
//
//        int hash = 0;
//        for (int i = 0; i < p.size() - 1; i++) {
//            int h1 = p.get(i).hashCode();
//            int h2 = p.get(i + 1).hashCode();
//            int segment = 31 * (h1 + h2) + h1 * h2;
//            hash += mix(segment);
//        }
//        return hash;
//    }
//
//    private static boolean samePath(List<Point> a, List<Point> b) {
//        if (a.size() != b.size()) return false;
//        if (a.isEmpty()) return true;
//
//        boolean cycleA = isCycle(a), cycleB = isCycle(b);
//        if (cycleA != cycleB) return false;
//
//        if (!cycleA) {
//            return a.equals(b) || a.equals(b.reversed());
//        }
//        List<Point> ca = a.subList(0, a.size() - 1);
//        List<Point> cb = b.subList(0, b.size() - 1);
//        return isRotation(ca, cb) || isRotation(ca, cb.reversed());
//    }
//
//    private static boolean isCycle(List<Point> p) {
//        return p.size() > 2 && p.getFirst().equals(p.getLast());
//    }
//
//    private static boolean isRotation(List<Point> a, List<Point> b) {
//        int n = a.size();
//        for (int shift = 0; shift < n; shift++) {
//            boolean ok = true;
//            for (int i = 0; i < n && ok; i++) {
//                ok = a.get(i).equals(b.get((i + shift) % n));
//            }
//            if (ok) return true;
//        }
//        return false;
//    }
//
//    private static int mix(int h) {
//        h ^= h >>> 16; h *= 0x85ebca6b;
//        h ^= h >>> 13; h *= 0xc2b2ae35;
//        return h ^ (h >>> 16);
//    }
//
//    @Override
//    public String toString() {
//        String resValue = "Линия [";
//        for (int i = 0; i < points.size() - 1; i++) {
//            resValue += (points.get(i) + ", ");
//        }
//        resValue += (points.getLast() + "]");
//        return resValue;
//    }
//
//    @Override
//    public PolygonalLine<T> getPolyline() {
//        return this;
//    }
//
//    @Override
//    public PolygonalLine<T> clone(){
//        try {
//            PolygonalLine<T> res = (PolygonalLine<T>) super.clone();
//            for (Point point:this.points){
//                res.points.add(point.clone());
//            }
//            return res;
//        }catch (CloneNotSupportedException e){
//            throw new RuntimeException(e);
//        }
//    }
}
