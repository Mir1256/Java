package ru.lobankov.geometry;

public class Triangle extends Figure{
    private int a,b,c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double square() {
        double p = (double) (a + b + c) /2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
