package ru.lobankov.numbers;

public final class Fraction extends Number{
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator must not be zero");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }   else{
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction sum(Fraction fraction){
        if (this.denominator == fraction.denominator) return new Fraction(this.numerator + fraction.numerator, this.denominator);
        return new Fraction(this.numerator* fraction.denominator + fraction.numerator*this.denominator,
                this.denominator* fraction.denominator);
    }
    public Fraction div(Fraction fraction){
        if (fraction.numerator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new Fraction(this.numerator* fraction.denominator, this.denominator * fraction.numerator);
    }
    public Fraction minus(Fraction fraction){
        if (this.denominator == fraction.denominator) return new Fraction(this.numerator - fraction.numerator, this.denominator);
        return new Fraction(this.numerator* fraction.denominator - fraction.numerator*this.denominator,
                this.denominator* fraction.denominator);
    }
    public Fraction mul(Fraction fraction){
        return new Fraction(this.numerator* fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction sum(int number){
        Fraction fraction = new Fraction(number,1);
        return sum(fraction);
    }
    public Fraction div(int number){
        Fraction fraction = new Fraction(number,1);
        return div(fraction);
    }
    public Fraction minus(int number){
        Fraction fraction = new Fraction(number,1);
        return minus(fraction);
    }
    public Fraction mul(int number){
        Fraction fraction = new Fraction(number,1);
        return mul(fraction);
    }

    @Override public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override public long longValue() {
        return (long) numerator / denominator;
    }

    @Override public int intValue() {
        return numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator +
                "/" + denominator;
    }
}
