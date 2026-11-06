package ru.lobankov.geometry;

import ru.lobankov.exceptions.DifferentDimensionsException;

import java.util.Objects;

public final class Point3D extends Point{
    private int z;
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point point) {
        super(point);
        this.z = (point instanceof  Point3D) ? ((Point3D) point).getZ() : 0;
    }

    public int getZ(){
        return z;
    }

    public void setZ(int z){
        this.z = z;
    }

    @Override
    public double dist(Point p) {
        if (p instanceof Point3D point3D){
            double dx = this.getX() - point3D.getX();
            double dy = this.getY() - point3D.getY();
            double dz = this.getZ() - point3D.getZ();

            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        } else {
            throw new DifferentDimensionsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return z == point3D.z;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Integer.hashCode(z);
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + getZ() + "}";
    }
}
