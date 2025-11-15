package Observer;

public class Timer extends Subject {
    public void tick(int seconds) {
        System.out.println("Timer tick: " + seconds + " sec");
        setValue(seconds);
    }
}
