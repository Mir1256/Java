package tasker;

public class CheckBinary implements Checker {
    public static final CheckBinary INTSTANCE = new CheckBinary();

    private CheckBinary(){}

    @Override
    public boolean isCorrect(Number number) {
        return number.intValue() == 1 || number.intValue() == 0;
    }
}
