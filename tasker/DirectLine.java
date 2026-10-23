package Java.tasker;

public class DirectLine implements Lengthable {
    private Point startPoint;
    private Point endPoint;


    public DirectLine(DirectLine line){
        this(line.startPoint,line.endPoint);
    }

    public DirectLine(Point startPoint, Point endPoint) {
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
        this.startPoint.setX(startPoint.getX());
        this.startPoint.setY(startPoint.getY());
    }

    public void setStartPoint(int x, int y) {
        this.startPoint.setX(x);
        this.startPoint.setY(y);
    }

    public void setEndPoint(Point endPoint) {
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
    public String toString() {
        return "Линия от {" + startPoint.getX() + ";" + startPoint.getY() + "} до {" + endPoint.getX() + ";" + endPoint.getY() + "}" ;
    }
}
