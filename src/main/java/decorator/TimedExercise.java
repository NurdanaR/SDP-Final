package decorator;

import factory.Exercise;

public class TimedExercise extends ExerciseDecorator {

    private int seconds;

    public TimedExercise(Exercise exercise, int seconds) {
        super(exercise);
        this.seconds = seconds;
    }

    @Override
    public String getName() {
        return exercise.getName() + " (Timed)";
    }

    @Override
    public String getType() {
        return exercise.getType();
    }

    @Override
    public int getCalories() {
        return exercise.getCalories() + seconds / 5; // extra calories for duration
    }

    @Override
    public String getDetails() {
        return exercise.getDetails() + ", Duration: " + seconds + " sec";
    }

    @Override
    public void perform() {
        exercise.perform();
        System.out.println("Additional Time: " + seconds + " seconds");
        System.out.println("Total Calories: ~" + getCalories() + " kcal");
    }
}
