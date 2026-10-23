package tasker;

public class Cat {
    public String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow(){
        System.out.println(name + ": мяу!");

    }

    public void meow(int count){
        String res = name + ": ";
        for (int i = 0; i < count-1; i++) {
            res+=("мяу-");
        }
        res+=("мяу!");
        System.out.println(res);
    }

    @Override
    public String toString() {
        return "Кот: " + name;
    }
}
