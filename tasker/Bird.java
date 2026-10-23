package Java.tasker;

abstract class Bird {
    private final String song;

    public Bird(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public void sing(){
        System.out.println(song);
    }
}
