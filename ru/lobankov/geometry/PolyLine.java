package ru.lobankov.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolyLine<T extends Point> implements Lengthable, PolyLineable, Cloneable {
    private List<T> points;

    @SafeVarargs
    public PolyLine(T... points){
        this((Arrays.asList(points)));
    }

    public PolyLine(List<T> points){
        this.points = new ArrayList<>();
        addAllPoint(points);
    }

    public PolyLine(PolyLine<T> line){
        this(line.points);
    }

    private T downgradeTo2D(T point){
        return (T) new Point(point.getX(), point.getY());
    }

    private T upgradeTo3D(T point){
        if (point.getClass() == Point3D.class){
            return (T) point.clone();
        }
        return (T) new Point3D(point.getX(), point.getY(), 0);
    }

    public List<T> getPoints() {
        return points;
    }

    public void setPoints(List<T> points) {
        this.points.addAll(points);
    }

    public void addAllPoint(List<T> points){
        List<T> res = new ArrayList<>();
        T cmpPoint = points.getFirst();
        for (int i = 0; i < points.size(); i++) {
            if (cmpPoint.getClass() != points.get(i).getClass()){
                T updatePoint = downgradeTo2D(points.get(i));
                points.set(i, updatePoint);
            }
        }
    }

    public void addPoint(T point){
        if (point.getClass() != points.getLast().getClass()){
            this.points.add(downgradeTo2D(point));
        }else {
            this.points.add(point);
        }
    }

    public List<T> normalizInator() {
        List<T> result = new ArrayList<>();
        for (T p : path()) {
            if (result.size() >= 2 && isStraight(result.get(result.size() - 2), result.getLast(), p)) {
                result.removeLast();   // предыдущая точка лишняя — линия идёт прямо через неё
            }
            result.add(p);
        }
        return result;
    }

    // b лежит на прямом отрезке a → c: на одной прямой и в том же направлении
    private static boolean isStraight(Point a, Point b, Point c) {
        long dx1 = b.getX() - a.getX(), dy1 = b.getY() - a.getY();
        long dx2 = c.getX() - b.getX(), dy2 = c.getY() - b.getY();
        boolean collinear = dx1 * dy2 - dy1 * dx2 == 0;   // векторное произведение
        boolean forward   = dx1 * dx2 + dy1 * dy2 > 0;    // скалярное: не разворот
        return collinear && forward;
    }

    public double length(){
        List<T> pointsList = normalizInator();
        double res = 0;
        for (int i = 0; i < pointsList.size() - 1; i++) {
            res += pointsList.get(i).dist(pointsList.get(i+1));
        }
        return res;
    }

    // Точки в том порядке, в котором по ним проходит линия.
    // Замкнутая ломаная переопределяет метод и возвращается в начальную точку.
    protected List<T> path() {
        return points;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof PolyLine<?> other)) return false;
        return samePath(this.path(), other.path());
    }

    @Override
    public int hashCode() {
        List<T> p = path();
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

    private static boolean samePath(List<? extends Point> a, List<? extends Point> b) {
        if (a.size() != b.size()) return false;
        if (a.isEmpty()) return true;

        boolean cycleA = isCycle(a), cycleB = isCycle(b);
        if (cycleA != cycleB) return false;

        if (!cycleA) {
            return a.equals(b) || a.equals(b.reversed());
        }
        List<? extends Point> ca = a.subList(0, a.size() - 1);
        List<? extends Point> cb = b.subList(0, b.size() - 1);
        return isRotation(ca, cb) || isRotation(ca, cb.reversed());
    }

    private static boolean isCycle(List<? extends Point> p) {
        return p.size() > 2 && p.getFirst().equals(p.getLast());
    }

    private static boolean isRotation(List<? extends Point> a, List<? extends Point> b) {
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
    public PolyLine<T> getPolyline() {
        return this;
    }

    @Override
    public PolyLine<T> clone(){
        try {
            PolyLine<T> res = (PolyLine<T>) super.clone();
            res.points = new ArrayList<>();
            for (Point point:this.points){
                res.points.add((T) point.clone());
            }
            return res;
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }
}
