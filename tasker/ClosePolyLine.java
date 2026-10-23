package tasker;

import java.util.Arrays;
import java.util.List;

public class ClosePolyLine extends PolygonalLine implements Lengthable{
    public ClosePolyLine(Point... points) {
        super(points);
    }

    public ClosePolyLine(List<Point> points) {
        super(points);
    }

    public ClosePolyLine(PolygonalLine line) {
        super(line);
    }

    @Override
    public double length() {
        if (normalizInator().size() > 2) {
            return super.length() + Point.distPoint2D(this.getPoints().getLast(),this.getPoints().getFirst());
        }
        return super.length();
    }
}
