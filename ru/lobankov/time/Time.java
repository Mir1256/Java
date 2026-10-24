package ru.lobankov.time;

public class Time {
    private static final int SKIP_DAY = 86400;
    private static final int NEXT_DAY = 86399;
    private int seconds;

    public Time(int seconds){
        this.seconds = seconds;
        nowDay();
    }

    public Time(){}

    private void nowDay(){
        while (seconds > NEXT_DAY){
            seconds -= SKIP_DAY;
        }
    }

    public String toString(){
         nowDay();

         int seconds = this.seconds;

        int minutes = seconds / 60;
        seconds %= 60;

        int hours = minutes / 60;
        minutes %= 60;

        String resHours = Integer.toString(hours);
        String resMinutes = Integer.toString(minutes);
        String resSeconds = Integer.toString(seconds);

        resSeconds = seconds < 10 ?"0"+resSeconds:resSeconds;
        resMinutes = minutes < 10 ?"0"+resMinutes:resMinutes;
        return resHours + ":" + resMinutes + ":" + resSeconds;
    }
}
