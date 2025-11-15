package Observer;

public class HeartRateMonitor implements Observer {

    @Override
    public void update(int seconds) {
        int heartRate = 90 + seconds / 2;
        System.out.println("Current heart rate: " + heartRate);
    }
}
