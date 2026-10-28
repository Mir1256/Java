package ru.lobankov.geometry;

import ru.lobankov.numbers.Fraction;

import java.util.Objects;

public class DirectLine implements Lengthable, Cloneable{
    private Point startPoint;
    private Point endPoint;


    public DirectLine(DirectLine line){
        if (line == null) {
            throw new IllegalArgumentException("New line must not be null");
        }
        this(line.startPoint,line.endPoint);
    }

    public DirectLine(Point startPoint, Point endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new IllegalArgumentException("Points must not be null");
        }
        this.startPoint = new Point(startPoint);
        this.endPoint = new Point(endPoint);
    }

    public DirectLine(int x1, int y1, int x2, int y2) {
        this.startPoint = new Point(x1,y1);
        this.endPoint = new Point(x2,y2);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setStartPoint(Point startPoint) {
        if (startPoint == null) {
            throw new IllegalArgumentException("New point must not be null");
        }
        this.startPoint.setX(startPoint.getX());
        this.startPoint.setY(startPoint.getY());
    }

    public void setStartPoint(int x, int y) {
        this.startPoint.setX(x);
        this.startPoint.setY(y);
    }

    public void setEndPoint(Point endPoint) {
        if (endPoint == null) {
            throw new IllegalArgumentException("New point must not be null");
        }
        this.endPoint.setX(endPoint.getX());
        this.endPoint.setY(endPoint.getY());
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof DirectLine ob){
            return ob.startPoint.equals(this.startPoint) && ob.endPoint.equals(this.endPoint)
                    || ob.startPoint.equals(this.endPoint) && ob.endPoint.equals(this.startPoint);
        }
        return false;
    }

    @Override
    public DirectLine clone(){
        try {
            DirectLine copyLine = (DirectLine) super.clone();
            copyLine.startPoint = this.startPoint.clone();
            copyLine.endPoint = this.endPoint.clone();
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
        return "Линия от {" + startPoint.getX() + ";" + startPoint.getY() + "} до {" + endPoint.getX() + ";" + endPoint.getY() + "}" ;
    }
}
