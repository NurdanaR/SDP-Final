package decorator;

import factory.Exercise;

public class WeightedExercise extends ExerciseDecorator {

    private int weight;

    public WeightedExercise(Exercise exercise, int weight) {
        super(exercise);
        this.weight = weight;
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
        System.out.println("Added weight: " + weight + " kg");
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
