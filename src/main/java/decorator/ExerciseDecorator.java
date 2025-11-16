package decorator;

import factory.Exercise;

public abstract class ExerciseDecorator implements Exercise {

    protected Exercise exercise;

    public ExerciseDecorator(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public void perform() {
        exercise.perform();
    }
}
