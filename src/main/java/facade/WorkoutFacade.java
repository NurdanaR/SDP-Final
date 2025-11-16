package facade;

import Strategy.WorkoutStrategy;
import Observer.*;
import decorator.Exercise;

public class WorkoutFacade {

    private WorkoutStrategy strategy;
    private Exercise exercise;

    public WorkoutFacade(WorkoutStrategy strategy, Exercise exercise) {
        this.strategy = strategy;
        this.exercise = exercise;
    }

    public void startWorkout() {
        System.out.println("\n===== START WORKOUT =====");


        System.out.println("Applying workout strategy:");
        strategy.executeWorkout();


        Timer timer = new Timer();
        timer.attach(new CalorieCounter());
        timer.attach(new HeartRateMonitor());


        System.out.println("\nPerforming exercise:");
        exercise.perform();


        System.out.println("\nRunning time tracking...");
        timer.tick(10);
        timer.tick(20);
        timer.tick(30);

        System.out.println("===== WORKOUT COMPLETE =====");
    }
}
