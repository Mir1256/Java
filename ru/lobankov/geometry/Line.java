package ru.lobankov.geometry;

public class Line<T extends Point> implements Lengthable, Cloneable {
    private T startPoint;
    private T endPoint;

    public Line(Line<T> line){
        if (line == null) {
            throw new IllegalArgumentException("New line must not be null");
        }
        this(line.startPoint,line.endPoint);
    }

    private Line(T startPoint, T endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new IllegalArgumentException("Points must not be null");
        }
        unifyPoints(startPoint, endPoint);
    }

    public static Line<Point> of(int x1, int y1, int x2, int y2) {
        return new Line<>(new Point(x1, y1), new Point(x2, y2));
    }

    public static Line<Point3D> of(int x1, int y1, int z1, int x2, int y2, int z2) {
        return new Line<>(new Point3D(x1, y1, z1), new Point3D(x2, y2, z2));
    }

    private void unifyPoints(T startPoint, T endPoint){
        if (startPoint.getClass() != endPoint.getClass()){
            this.startPoint = downgradeTo2D(startPoint);
            this.endPoint = downgradeTo2D(endPoint);
        } else{
            this.startPoint = (T) startPoint.clone();
            this.endPoint = (T) endPoint.clone();
        }
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

    public T getStartPoint() {
        return startPoint;
    }

    public T getEndPoint() {
        return endPoint;
    }

    public void setStartPoint(T startPoint) {
        if (startPoint == null) {
            throw new IllegalArgumentException("New point must not be null");
        }

        unifyPoints(startPoint, this.endPoint);
    }

    public void setEndPoint(T endPoint) {
        if (endPoint == null) {
            throw new IllegalArgumentException("New point must not be null");
        }

        unifyPoints(this.startPoint, endPoint);
    }

    public double length(){
        return startPoint.dist(endPoint);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof Line<? extends Point> ob){
            return ob.startPoint.equals(this.startPoint) && ob.endPoint.equals(this.endPoint)
                    || ob.startPoint.equals(this.endPoint) && ob.endPoint.equals(this.startPoint);
        }
        return false;
    }

    @Override
    public Line<T> clone(){
        try {
            Line<T> copyLine = (Line<T>) super.clone();
            copyLine.startPoint = (T) startPoint.clone();
            copyLine.endPoint = (T) endPoint.clone();
            return copyLine;
        } catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        Integer h1 = this.startPoint.hashCode(), h2 = this.endPoint.hashCode();
        return 31 * (h1 + h2) + (h1 * h2);
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }
}
