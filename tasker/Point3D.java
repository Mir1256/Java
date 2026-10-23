package tasker;

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

    public static double dist(Point3D p1, Point3D p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        double dz = p1.getZ() - p2.getZ();

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + getZ() + "}";
    }
}
