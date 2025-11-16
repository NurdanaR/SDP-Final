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
        return "";
    }



    @Override
    public String getType() {
        return "";
    }

    @Override
    public void perform() {
        super.perform();
        System.out.println("Duration: " + seconds + " seconds");
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public String getDetails() {
        return "";
    }
}
