package builder;

import factory.Exercise;
import java.util.ArrayList;
import java.util.List;


public class WorkoutPlanBuilder {

    // Same fields as WorkoutPlan
    String name;
    List<Exercise> exercises;
    int sets;
    int reps;
    int restTime;
    int totalDuration;
    String difficulty;
    String description;


    public WorkoutPlanBuilder() {
        this.exercises = new ArrayList<>();
        this.sets = 3;              // Default: 3 sets
        this.reps = 10;             // Default: 10 reps
        this.restTime = 60;         // Default: 60 seconds rest
        this.totalDuration = 45;    // Default: 45 minutes
        this.difficulty = "Intermediate";  // Default difficulty
        this.description = "";
    }


    public WorkoutPlanBuilder setName(String name) {
        this.name = name;
        return this;
    }


    public WorkoutPlanBuilder addExercise(Exercise exercise) {
        if (exercise != null) {
            this.exercises.add(exercise);
        }
        return this;
    }


    public WorkoutPlanBuilder addExercises(List<Exercise> exercises) {
        if (exercises != null) {
            this.exercises.addAll(exercises);
        }
        return this;
    }


    public WorkoutPlanBuilder setSets(int sets) {
        if (sets > 0) {
            this.sets = sets;
        }
        return this;
    }


    public WorkoutPlanBuilder setReps(int reps) {
        if (reps > 0) {
            this.reps = reps;
        }
        return this;
    }


    public WorkoutPlanBuilder setRestTime(int restTime) {
        if (restTime >= 0) {
            this.restTime = restTime;
        }
        return this;
    }


    public WorkoutPlanBuilder setDuration(int duration) {
        if (duration > 0) {
            this.totalDuration = duration;
        }
        return this;
    }

    public WorkoutPlanBuilder setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }


    public WorkoutPlanBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public WorkoutPlan build() {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Workout plan must have a name!");
        }

        if (exercises.isEmpty()) {
            throw new IllegalStateException("Workout plan must have at least one exercise!");
        }


        return new WorkoutPlan(this);
    }


    public WorkoutPlanBuilder reset() {
        this.exercises.clear();
        this.name = null;
        this.sets = 3;
        this.reps = 10;
        this.restTime = 60;
        this.totalDuration = 45;
        this.difficulty = "Intermediate";
        this.description = "";
        return this;
    }
}