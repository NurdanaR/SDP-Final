package decorator;

import factory.Exercise;

public class WeightedExercise extends ExerciseDecorator {

    private double extraWeight;

    public WeightedExercise(Exercise exercise, double extraWeight) {
        super(exercise);
        this.extraWeight = extraWeight;
    }

    @Override
    public String getName() {
        return exercise.getName() + " (Weighted)";
    }

    @Override
    public String getType() {
        return exercise.getType();
    }

    @Override
    public int getCalories() {
        return exercise.getCalories() + (int)(extraWeight * 0.5);
    }

    @Override
    public String getDetails() {
        return exercise.getDetails() + ", Extra Weight: " + extraWeight + " kg";
    }

    @Override
    public void perform() {
        exercise.perform();
        System.out.println("Added Weight: " + extraWeight + " kg");
        System.out.println("Total Calories: ~" + getCalories() + " kcal");
    }
}
