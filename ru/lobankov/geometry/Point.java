package ru.lobankov.geometry;

public sealed class Point implements Cloneable permits Point3D {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        if (point == null) {
            throw new IllegalArgumentException("Point must not be null");
        }
        this.x = point.getX();
        this.y = point.getY();
    }

    public double dist(Point p){
        if (p == null) {
            throw new IllegalArgumentException("Point must not be null");
        }
        return Math.sqrt(
                (Math.pow((double)this.getX() - (double) p.getX(), 2.0) +
                        Math.pow((double)this.getY() - (double) p.getY(),2.0))
        );
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() == getClass()){
            Point ob = (Point) obj;
            return ob.x == this.x && ob.y == this.y;
        }
        return false;
    }

    @Override
    public Point clone(){
        try {
            return (Point) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return 31*Integer.hashCode(x) + Integer.hashCode(y);
    }

    @Override
    public String toString(){
        return "{"+this.x+";"+this.y+"}";
    }
}
