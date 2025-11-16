import Strategy.*;
import decorator.*;
import facade.WorkoutFacade;

public class Main {
    public static void main(String[] args) {


        WorkoutStrategy strategy = new FatBurnStrategy();


        Exercise exercise = new Exercise() {
            @Override
            public void perform() {
                System.out.println("Doing base exercise...");
            }
        };


        exercise = new WeightedExercise(exercise, 15);
        exercise = new TimedExercise(exercise, 45);


        WorkoutFacade facade = new WorkoutFacade(strategy, exercise);
        facade.startWorkout();
    }
}
