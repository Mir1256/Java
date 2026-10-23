package tasker;

public class Time {
    private static final int skipDay = 86399;
    int seconds;

    public Time(int seconds){
        nowDay();

        this.seconds = seconds;
    }

    public Time(){}

    private void nowDay(){
        if (seconds > skipDay){
            seconds -= skipDay;
        }
    }



    public String toString(){
         nowDay();

        int minutes = seconds / 60;
        seconds %= 60;

        int hours = minutes / 60;
        minutes %= 60;

        String resHours = Integer.toString(hours);
        String resMinutes = Integer.toString(minutes);
        String resSeconds = Integer.toString(seconds);

        resSeconds = seconds < 10 ?"0"+resSeconds:resSeconds;
        resMinutes = minutes < 10 ?"0"+resMinutes:resMinutes;
        resHours = hours < 10 ?"0"+resHours:resHours;
        return resHours + ":" + resMinutes + ":" + resSeconds;
    }
}
