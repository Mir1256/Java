package ru.lobankov.geometry;

public sealed class Point permits Point3D {
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

    public static double distPoint2D(Point p1, Point p2){
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("Point must not be null");
        }
        return Math.sqrt(
                (Math.pow((double)p1.getX() - (double) p2.getX(), 2.0) +
                        Math.pow((double)p1.getY() - (double) p2.getY(),2.0))
        );
    }

    public double dist(Point p1, Point p2){
        return distPoint2D(p1,p2);
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
    public String toString(){
        return "{"+this.x+";"+this.y+"}";
    }
}
