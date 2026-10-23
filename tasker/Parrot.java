package Java.tasker;

public class Parrot extends Bird{
    public Parrot(String song) {
        super(song);
    }

    @Override
    public void sing() {
        int n = (int)(Math.random()*getSong().length());
        for (int i = 0; i < n; i++) {
            System.out.print(getSong().charAt(i));
        }
        System.out.println();
    }
}
