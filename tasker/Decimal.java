package tasker;

public final class Decimal extends Number{
    private final int numerator;
    private final int denominator;

    public Decimal(int numerator, int denominator) {
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

    public Decimal sum(Decimal decimal){
        if (this.denominator == decimal.denominator) return new Decimal(this.numerator + decimal.numerator, this.denominator);
        return new Decimal(this.numerator*decimal.denominator + decimal.numerator*this.denominator,
                this.denominator*decimal.denominator);
    }
    public Decimal div(Decimal decimal){
        return new Decimal(this.numerator*decimal.denominator, this.denominator * decimal.numerator);
    }
    public Decimal sub(Decimal decimal){
        if (this.denominator == decimal.denominator) return new Decimal(this.numerator - decimal.numerator, this.denominator);
        return new Decimal(this.numerator*decimal.denominator - decimal.numerator*this.denominator,
                this.denominator*decimal.denominator);

    }
    public Decimal mul(Decimal decimal){
        return new Decimal(this.numerator*decimal.numerator, this.denominator * decimal.denominator);
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
