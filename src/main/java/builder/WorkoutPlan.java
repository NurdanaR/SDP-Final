package builder;


import factory.Exercise;

import java.util.ArrayList;
import java.util.List;


public class WorkoutPlan {

    // Required fields
    private String name;
    private List<Exercise> exercises;

    // Optional fields
    private int sets;
    private int reps;
    private int restTime;        // seconds between sets
    private int totalDuration;   // minutes
    private String difficulty;   // Beginner, Intermediate, Advanced
    private String description;

    WorkoutPlan(WorkoutPlanBuilder builder) {
        this.name = builder.name;
        this.exercises = builder.exercises;
        this.sets = builder.sets;
        this.reps = builder.reps;
        this.restTime = builder.restTime;
        this.totalDuration = builder.totalDuration;
        this.difficulty = builder.difficulty;
        this.description = builder.description;
    }


    public void displayPlan() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║              WORKOUT PLAN                                ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("  Name: " + name);
        System.out.println("  Difficulty: " + difficulty);
        System.out.println("  Total Duration: " + totalDuration + " minutes");
        if (description != null && !description.isEmpty()) {
            System.out.println("  Description: " + description);
        }
        System.out.println("  Sets: " + sets + " | Reps: " + reps + " | Rest: " + restTime + "s");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("  Exercises (" + exercises.size() + " total):");

        int totalCalories = 0;
        for (int i = 0; i < exercises.size(); i++) {
            Exercise ex = exercises.get(i);
            System.out.println("  " + (i + 1) + ". " + ex.getName() +
                    " (" + ex.getType() + ") - " + ex.getCalories() + " kcal");
            totalCalories += ex.getCalories();
        }

        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("  Total Estimated Calories: " + (totalCalories * sets) + " kcal");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }


    public String getSummary() {
        return String.format("%s (%s) - %d exercises, %d sets, %d minutes",
                name, difficulty, exercises.size(), sets, totalDuration);
    }


    public String getName() { return name; }
    public List<Exercise> getExercises() { return new ArrayList<>(exercises); }
    public int getSets() { return sets; }
    public int getReps() { return reps; }
    public int getRestTime() { return restTime; }
    public int getTotalDuration() { return totalDuration; }
    public String getDifficulty() { return difficulty; }
    public String getDescription() { return description; }


    public int getTotalCalories() {
        int total = 0;
        for (Exercise ex : exercises) {
            total += ex.getCalories();
        }
        return total * sets;
    }
}