package Observer;

public class CalorieCounter implements Observer {

    private int caloriesBurned = 0;

    @Override
    public void update(int seconds) {
        caloriesBurned += seconds * 0.15;
        System.out.println("Calories burned: " + caloriesBurned);
    }
}
