package builder;

import factory.Exercise;
import factory.ExerciseFactory;

public class WorkoutDirector {

    private WorkoutPlanBuilder builder;
    private ExerciseFactory factory;

    public WorkoutDirector() {
        this.builder = new WorkoutPlanBuilder();
        this.factory = new ExerciseFactory();
    }

    public WorkoutPlan constructBeginnerPlan() {
        System.out.println("Creating Beginner Workout Plan...");

        Exercise cardio = factory.createQuickExercise("cardio", "Light Jogging");
        Exercise stretch1 = factory.createQuickExercise("stretching", "Hamstring Stretch");
        Exercise stretch2 = factory.createQuickExercise("stretching", "Shoulder Stretch");

        return builder.reset()
                .setName("Beginner Full Body")
                .setDifficulty("Beginner")
                .setDescription("Perfect for those starting their fitness journey")
                .addExercise(stretch1)
                .addExercise(cardio)
                .addExercise(stretch2)
                .setSets(2)
                .setReps(8)
                .setRestTime(90)
                .setDuration(30)
                .build();
    }

    public WorkoutPlan constructIntermediatePlan() {
        System.out.println("Creating Intermediate Workout Plan...");

        Exercise cardio = factory.createQuickExercise("cardio", "Running");
        Exercise strength1 = factory.createQuickExercise("strength", "Push-ups");
        Exercise strength2 = factory.createQuickExercise("strength", "Squats");
        Exercise yoga = factory.createQuickExercise("yoga", "Warrior Pose");

        return builder.reset()
                .setName("Intermediate Total Body")
                .setDifficulty("Intermediate")
                .setDescription("Balanced workout for regular fitness enthusiasts")
                .addExercise(cardio)
                .addExercise(strength1)
                .addExercise(strength2)
                .addExercise(yoga)
                .setSets(3)
                .setReps(12)
                .setRestTime(60)
                .setDuration(45)
                .build();
    }

    public WorkoutPlan constructAdvancedPlan() {
        System.out.println("Creating Advanced Workout Plan...");

        Exercise cardio = factory.createQuickExercise("cardio", "HIIT Sprints");
        Exercise strength1 = factory.createQuickExercise("strength", "Deadlifts");
        Exercise strength2 = factory.createQuickExercise("strength", "Bench Press");
        Exercise strength3 = factory.createQuickExercise("strength", "Pull-ups");
        Exercise yoga = factory.createQuickExercise("yoga", "Advanced Flow");
        Exercise stretch = factory.createQuickExercise("stretching", "Deep Stretches");

        return builder.reset()
                .setName("Advanced Athlete Training")
                .setDifficulty("Advanced")
                .setDescription("High-intensity workout for experienced athletes")
                .addExercise(cardio)
                .addExercise(strength1)
                .addExercise(strength2)
                .addExercise(strength3)
                .addExercise(yoga)
                .addExercise(stretch)
                .setSets(4)
                .setReps(15)
                .setRestTime(45)
                .setDuration(60)
                .build();
    }

    public WorkoutPlan constructCardioPlan() {
        System.out.println("Creating Cardio-Focused Workout Plan...");

        Exercise warmup = factory.createQuickExercise("stretching", "Dynamic Stretches");
        Exercise cardio1 = factory.createQuickExercise("cardio", "Running");
        Exercise cardio2 = factory.createQuickExercise("cardio", "Cycling");
        Exercise cooldown = factory.createQuickExercise("stretching", "Cool Down Stretches");

        return builder.reset()
                .setName("Cardio Blast")
                .setDifficulty("Intermediate")
                .setDescription("Heart-pumping cardio workout")
                .addExercise(warmup)
                .addExercise(cardio1)
                .addExercise(cardio2)
                .addExercise(cooldown)
                .setSets(3)
                .setReps(1)
                .setRestTime(30)
                .setDuration(40)
                .build();
    }

    public WorkoutPlan constructStrengthPlan() {
        System.out.println("Creating Strength-Focused Workout Plan...");

        Exercise warmup = factory.createQuickExercise("stretching", "Warmup Stretches");
        Exercise strength1 = factory.createQuickExercise("strength", "Squats");
        Exercise strength2 = factory.createQuickExercise("strength", "Bench Press");
        Exercise strength3 = factory.createQuickExercise("strength", "Deadlifts");
        Exercise strength4 = factory.createQuickExercise("strength", "Overhead Press");

        return builder.reset()
                .setName("Strength Builder")
                .setDifficulty("Advanced")
                .setDescription("Build muscle and increase strength")
                .addExercise(warmup)
                .addExercise(strength1)
                .addExercise(strength2)
                .addExercise(strength3)
                .addExercise(strength4)
                .setSets(4)
                .setReps(8)
                .setRestTime(120)
                .setDuration(60)
                .build();
    }
}
