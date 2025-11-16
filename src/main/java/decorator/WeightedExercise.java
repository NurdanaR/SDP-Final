package decorator;

public class WeightedExercise extends ExerciseDecorator {

    private int weight;

    public WeightedExercise(Exercise exercise, int weight) {
        super(exercise);
        this.weight = weight;
    }

    @Override
    public void perform() {
        super.perform();
        System.out.println("Added weight: " + weight + " kg");
    }
}
