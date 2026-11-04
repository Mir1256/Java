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

    public DirectLine(T startPoint, T endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new IllegalArgumentException("Points must not be null");
        }
        this.startPoint = copy(startPoint);
        this.endPoint = copy(endPoint);
    }

    public static DirectLine<Point> of(int x1, int y1, int x2, int y2) {
        return new DirectLine<>(new Point(x1, y1), new Point(x2, y2));
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
        this.startPoint = copy(startPoint);
    }

    public void setStartPoint(int x, int y) {
        this.startPoint.setX(x);
        this.startPoint.setY(y);
    }

    public void setEndPoint(T endPoint) {
        if (endPoint == null) {
            throw new IllegalArgumentException("New point must not be null");
        }
        this.endPoint = copy(endPoint);
    }

    public void setEndPoint(int x, int y) {
        this.endPoint.setX(x);
        this.endPoint.setY(y);
    }

    public double length(){
        return Math.rint(
                    Math.sqrt(
                        (Math.pow((double)startPoint.getX() - (double) endPoint.getX(), 2.0) +
                        Math.pow((double)startPoint.getY() - (double) endPoint.getY(),2.0))
                    )
        );
    }

    private T copy(T point){
        return (T) point.clone();
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
            copyLine.startPoint = copy(startPoint);
            copyLine.endPoint = copy(endPoint);
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
