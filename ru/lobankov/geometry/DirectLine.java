package ru.lobankov.geometry;

public class DirectLine<T extends Point> implements Lengthable, Cloneable {
    private T startPoint;
    private T endPoint;

    public DirectLine(DirectLine<T> line){
        if (line == null) {
            throw new IllegalArgumentException("New line must not be null");
        }
        this(line.startPoint,line.endPoint);
    }

    private DirectLine(T startPoint, T endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new IllegalArgumentException("Points must not be null");
        }
        if (startPoint.getClass() != endPoint.getClass()){
            this.startPoint = (T) new Point(startPoint.getX(), startPoint.getY());
            this.endPoint = (T) new Point(endPoint.getX(), endPoint.getY());
        } else{
            this.startPoint = (T) startPoint.clone();
            this.endPoint = (T) endPoint.clone();
        }
    }

    public static DirectLine<Point> of(int x1, int y1, int x2, int y2) {
        return new DirectLine<>(new Point(x1, y1), new Point(x2, y2));
    }

    public static DirectLine<Point3D> of(int x1, int y1, int z1, int x2, int y2, int z2) {
        return new DirectLine<>(new Point3D(x1, y1, z1), new Point3D(x2, y2, z2));
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setStartPoint(T startPoint) {
        if (startPoint == null) {
            throw new IllegalArgumentException("New point must not be null");
        }

        if (this.startPoint.getClass() != startPoint.getClass()){
            this.startPoint = (T) new Point(startPoint.getX(), startPoint.getY());
        }else {
            this.startPoint = (T) startPoint.clone();
        }
    }

    public void setEndPoint(T endPoint) {
        if (endPoint == null) {
            throw new IllegalArgumentException("New point must not be null");
        }

        if (this.endPoint.getClass() != endPoint.getClass()){
            this.endPoint = (T) new Point(endPoint.getX(), endPoint.getY());
        }else {
            this.endPoint = (T) endPoint.clone();
        }
    }

    public double length(){
        return startPoint.dist(endPoint);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof DirectLine<? extends Point> ob){
            return ob.startPoint.equals(this.startPoint) && ob.endPoint.equals(this.endPoint)
                    || ob.startPoint.equals(this.endPoint) && ob.endPoint.equals(this.startPoint);
        }
        return false;
    }

    @Override
    public DirectLine<T> clone(){
        try {
            DirectLine<T> copyLine = (DirectLine<T>) super.clone();
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
        return "Линия от {" + startPoint + "} до {" + endPoint + "}" ;
    }
}
