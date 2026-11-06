package ru.lobankov.geometry;

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

    public double dist(Point3D p) {
        double dx = this.getX() - p.getX();
        double dy = this.getY() - p.getY();
        double dz = this.getZ() - p.getZ();

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + getZ() + "}";
    }
}
