package Strategy;

public class MuscleGainStrategy implements WorkoutStrategy {
    @Override
    public void executeWorkout() {
        System.out.println("Muscle Gain Strategy: Heavy lifting, squats, bench press!");
    }
}
