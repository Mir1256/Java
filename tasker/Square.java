package tasker;

public class Square implements PolyLineable {
    private Point leftUpPoint;
    private int lenghtSide;

    public Square(Point startPoint, int lenghtSide) {
        this(startPoint.getX(),startPoint.getY(),lenghtSide);
    }
    public Square(int x, int y, int lenghtSide){
        if (lenghtSide < 0){
            throw new IllegalArgumentException("lenghtSide must be up zero");
        }
        this.leftUpPoint = new Point(x, y);
        this.lenghtSide = lenghtSide;
    }

    public Point getLeftUpPoint() {
        return leftUpPoint;
    }

    public void setLeftUpPoint(Point leftUpPoint) {
        if (leftUpPoint == null) {
            throw new IllegalArgumentException("Null of point its not correct");
        }
        this.leftUpPoint = leftUpPoint;
    }

    public int getLenghtSide() {
        return lenghtSide;
    }

    public void setLenghtSide(int lenghtSide) {
        this.lenghtSide = Math.max(lenghtSide, 0);
    }

    public PolygonalLine getPolyline(){
        Point[] points = {leftUpPoint, new Point(leftUpPoint.getX(),leftUpPoint.getY()+lenghtSide),
                new Point(leftUpPoint.getX()+lenghtSide, leftUpPoint.getY() + lenghtSide),
                new Point(leftUpPoint.getX(), leftUpPoint.getY()+lenghtSide)
        };
        return new ClosePolyLine(points);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + leftUpPoint + "со стороной" + lenghtSide;
    }
}
