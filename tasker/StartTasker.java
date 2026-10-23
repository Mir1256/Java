package tasker;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class StartTasker {
    public static void main(){
        Figure a = new Rectangle(1,2);
        Figure b = new Triangle(12,13,15);
        System.out.println(sumSquare(a,b));

        DirectLine l1 = new DirectLine(0,1,1,0);
        DirectLine l2 = new DirectLine(0,1,1,0);
        DirectLine l3 = new DirectLine(0,1,1,0);

        Shooter shooter = new Shooter("Питер", new Gun(5));
        Shooter shooter2 = new Shooter("Питер2", null);
        Shooter shooter3 = new Shooter("Питер3", new MachineGun());

        shooter.shoot();
        shooter2.shoot();
        shooter3.shoot();

    }

    public static double sum(Number... nums){
        double res = 0;
        for (Number number:nums){
            res+=number.doubleValue();
        }
        return res;
    }

    public static void sing(Bird... birds){
        for (Bird bird: birds){
            bird.sing();
        }
    }

    public static double sumSquare(Figure... figures){
        double res = 0;
        for (Figure figure:figures){
            res+=figure.square();
        }
        return res;
    }

    public static void meow(Meowable... meows){
        for (Meowable meow: meows){
            meow.meow();
        }
    }

    public static double sumLength(Lengthable... lengths){
        double sum = 0;
        for (Lengthable length:lengths){
            sum+=length.length();
        }
        return sum;
    }

    public static PolygonalLine createPolyChain(PolyLineable... polylines){
        PolygonalLine res = new PolygonalLine(polylines[0].getPolyline());
        for (PolyLineable polyline : polylines) {
            List<Point> points = polyline.getPolyline().getPoints();
            for (Point point : points) {
                res.addPoint(point);
            }
        }
        return res;
    }

    public static void test(List<Student> students, int grade){
        List<List<Integer>> allGrades = new ArrayList<>();

        for (Student student:students){
            allGrades.add(student.getGrades());
        }

        for (Student student: students){
            try{
                student.addGrade(grade);

            } catch (Exception e) {
                for (int i = 0; i < allGrades.size(); i++) {
                    students.get(i).setGrades(allGrades.get(i));
                }
            }
        }

    }
}
