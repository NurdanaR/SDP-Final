package Strategy;

public class FatBurnStrategy implements WorkoutStrategy {
    @Override
    public void executeWorkout() {
        System.out.println("Fat Burn Strategy: Running, HIIT, Jump rope!");
    }
}
