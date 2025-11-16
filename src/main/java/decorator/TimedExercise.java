package decorator;

public class TimedExercise extends ExerciseDecorator {

    private int seconds;

    public TimedExercise(Exercise exercise, int seconds) {
        super(exercise);
        this.seconds = seconds;
    }

    @Override
    public void perform() {
        super.perform();
        System.out.println("Duration: " + seconds + " seconds");
    }
}
