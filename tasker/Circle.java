package tasker;

public class Circle extends Figure{
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius less then zero can not be");
        }
        this.radius = radius;
    }

    @Override
    public double square() {
        return Math.PI*radius*radius;
    }
}
