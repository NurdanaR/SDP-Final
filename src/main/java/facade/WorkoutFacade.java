package facade;

import Strategy.WorkoutStrategy;
import Observer.*;
import factory.Exercise;


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
        CalorieCounter calorieCounter = new CalorieCounter();
        HeartRateMonitor heartRateMonitor = new HeartRateMonitor();

        timer.attach(calorieCounter);
        timer.attach(heartRateMonitor);

        System.out.println("\nPerforming exercise:");
        exercise.perform();

        System.out.println("\nRunning time tracking...");
        for (int seconds : new int[]{10, 20, 30}) {
            timer.tick(seconds);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }

        System.out.println("===== WORKOUT COMPLETE =====");
    }
}
