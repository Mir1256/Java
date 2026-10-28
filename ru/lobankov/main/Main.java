package ru.lobankov.main;
import ru.lobankov.animals.Bird;
import ru.lobankov.animals.Meowable;
import ru.lobankov.exceptions.AlreadyClosedException;
import ru.lobankov.exceptions.ConnectionLostException;
import ru.lobankov.exceptions.InvalidGradeException;
import ru.lobankov.exceptions.NoNumbersInAllStringException;
import ru.lobankov.geometry.*;
import ru.lobankov.geometry.Point;
import ru.lobankov.buildings.House;
import ru.lobankov.net.*;
import ru.lobankov.people.Name;
import ru.lobankov.study.Student;
import ru.lobankov.time.Time;

import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) throws InvalidGradeException {
        DirectLine line1 = new DirectLine(1,2,3,4);
        DirectLine line2 = new DirectLine(1,2,3,4);
        DirectLine line3 = new DirectLine(3,4,1,2);

        System.out.println(line1.equals(line2));
        System.out.println(line1.equals(line3));
        System.out.println(line1.hashCode() == line3.hashCode());
    }

    public static void testByStackTrace_4_2_4(){
        ExampleConnector connector = new ExampleConnector();
        Connection conn = new Connection("ru.lobankov");
        try {
            connector.makeConnect(conn);
            System.out.println("Connection success!");
        } catch (Exception e) {
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            if (stackTraceElements[0].getMethodName().equals("nextString")) {
                connector.unregister();
                System.out.println("Exception in nextString");
            }
            if (stackTraceElements[0].getMethodName().equals("register")){
                System.out.println("Exception in register");
            }

        }
    }
    public static void testByExceptions_4_2_4(){
        ExampleConnector connector = new ExampleConnector();
        Connection conn = new Connection("ru.lobankov");
        try {
            connector.makeConnect(conn);
            System.out.println("Connection success!");
        }
        catch (ConnectionLostException | AlreadyClosedException e){
            connector.unregister();
            System.out.println("Exception in nextString");
        }catch (RuntimeException e) {
            System.out.println("Exception in register");
        }
    }

    public static double divByManyString(String... potentialNumbers){
        double res = 0;
        boolean haveFirst = false;
        for (String potentialNumber: potentialNumbers){
            try {   
                int num = Integer.parseInt(potentialNumber);
                if (!haveFirst){
                    res = (double) num;
                }else{
                    res/=num;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        if (!haveFirst){
            throw new NoNumbersInAllStringException();
        }
        return res;
    }

    public static void readData_4_2_1(){
        try(Connection conn = new Connection("https://wwww.google.com")) {
            for (int i = 0; i < 10; i++){
                System.out.println(conn.nextString());
            }
        } catch (Exception e) {
            System.out.println("Something wrong with connection");
            throw new RuntimeException(e);
        }
    }

    public static void demoPoint(){
        System.out.println(new Point(1, 2));
        System.out.println(new Point(-5, 10));
        System.out.println(new Point(0, 0));
    }

    public static void demoHuman(){}

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

    public static void task_3_1_3(){
        BigInteger bg = new BigInteger("12345678912345678912");
        System.out.println(sum(7,113,3.21,bg));
    }

    public static double myPow(String x, String y){
        return pow(parseInt(x),parseInt(y));
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

    public static Student test3(String name, int... values) throws InvalidGradeException {return new Student(name, values);}

    public static void test2(int grade, Student... students) throws InvalidGradeException {

        try {
            for (Student student:students){
                Student s1 = new Student(student);
                s1.addGrade(grade);
            }
            Student s1 = new Student(students[0]);
            s1.addGrade(grade);
        } catch (InvalidGradeException e) {
            return;
        }
        for (Student student:students){
            student.addGrade(grade);
        }
    }

    public static void test1(List<Student> students, int grade) throws InvalidGradeException {
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
