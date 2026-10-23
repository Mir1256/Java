package ru.lobankov.main;
import ru.lobankov.animals.Bird;
import ru.lobankov.animals.Meowable;
import ru.lobankov.geometry.*;
import ru.lobankov.buildings.House;
import ru.lobankov.people.Name;
import ru.lobankov.study.Student;
import ru.lobankov.time.Time;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        demoName();
    }

    public static void demoPoint(){
        System.out.println(new Point(1, 2));
        System.out.println(new Point(-5, 10));
        System.out.println(new Point(0, 0));
    }

    public static void demoHuman(){
    }

    public static void demoName(){
        System.out.println(new Name("Клеопатра"));
        System.out.println(new Name("Пушкин Александр Сергеевич"));
        System.out.println(new Name("Маяковский Владимир"));
        System.out.println(new Name(" ", " ", "Ivan"));
    }

    public static void demoTime() {
        System.out.println(new Time(10));
        System.out.println(new Time(10000));
        System.out.println(new Time(100000));
    }

    public static void demoHouse(){
        System.out.println(new House(1));
        System.out.println(new House(5));
        System.out.println(new House(23));
        System.out.println(new House(11));
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
