package Java.tasker;

public class checkAnyEven implements Checker {
    @Override
    public boolean isCorrect(Number number) {
        return number.intValue() % 2 == 0;
    }
}
