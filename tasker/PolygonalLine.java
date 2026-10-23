package tasker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonalLine implements Lengthable, PolyLineable{
    private List<Point> points;

    public PolygonalLine(Point... points){
        this(Arrays.asList(points));
    }

    public PolygonalLine(List<Point> points){
        this.points = new ArrayList<>();
        this.points.addAll(points);
    }

    public PolygonalLine(PolygonalLine line){
        this(line.points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point){
        this.points.add(point);
    }

    public List<Point> normalizInator() {
        if (points == null || points.size() < 3) {
            return points == null ? new ArrayList<>() : new ArrayList<>(points);
        }

        List<Point> result = new ArrayList<>();
        result.add(points.getFirst());

        for (int i = 1; i < points.size() - 1; i++) {
            Point prev = result.getLast();
            Point cur  = points.get(i);
            Point next = points.get(i + 1);

            if (!isCollinear(prev, cur, next)) {
                result.add(cur);
            }
        }

        result.add(points.getLast());
        return result;
    }

    private static boolean isCollinear(Point a, Point b, Point c) {
        long cross = (long) (b.getX() - a.getX()) * (c.getY() - b.getY())
                - (long) (b.getY() - a.getY()) * (c.getX() - b.getX());
        return cross == 0;
    }

    public double length(){
        List<Point> pointsList = normalizInator();
        double res = 0;
        for (int i = 0; i < pointsList.size() - 1; i++) {
            res += Point.distPoint2D(pointsList.get(i),pointsList.get(i+1));
        }
        return res;
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
    public PolygonalLine getPolyline() {
        return this;
    }
}
