package Java.tasker;

public class Cuckoo extends Bird{
    public Cuckoo() {
        super("ку-ку");
    }

    @Override
    public void sing(){
        int n = (int)(Math.random()*10);
        for (int i = 0; i < n; i++) {
            super.sing();
        }
    }
}
