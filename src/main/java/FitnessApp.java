import builder.WorkoutDirector;
import builder.WorkoutPlan;
import builder.WorkoutPlanBuilder;
import factory.Exercise;
import factory.ExerciseFactory;
import decorator.TimedExercise;
import decorator.WeightedExercise;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Strategy.WorkoutStrategy;
import Strategy.FatBurnStrategy;
import facade.WorkoutFacade;

public class FitnessApp {

    private static Scanner scanner = new Scanner(System.in);
    private static ExerciseFactory exerciseFactory = new ExerciseFactory();
    private static WorkoutDirector director = new WorkoutDirector();

    public static void main(String[] args) {

        displayWelcomeBanner();

        boolean running = true;

        while (running) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    createCustomWorkout();
                    break;
                case 2:
                    usePreBuiltWorkout();
                    break;
                case 3:
                    demonstrateFactory();
                    break;
                case 4:
                    demonstrateBuilder();
                    break;
                case 5:
                    demonstrateIntegration();
                    break;
                case 6:
                    demonstrateDecorator();
                    break;
                case 7:
                    demonstrateFacadeDemo() ;
                    break;
                case 8:
                    running = false;
                    System.out.println("\nThank you for using the Fitness App!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayWelcomeBanner() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");
        System.out.println("║          FITNESS APPLICATION                              ║");
        System.out.println("║                                                          ║");
        System.out.println("║          Design Patterns Implementation                  ║");
        System.out.println("║          Student A: Factory + Builder + Decorator        ║");
        System.out.println("║                                                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    private static void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          MAIN MENU                     ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Create Custom Workout               ║");
        System.out.println("║ 2. Use Pre-built Workout               ║");
        System.out.println("║ 3. Factory Pattern Demo                ║");
        System.out.println("║ 4. Builder Pattern Demo                ║");
        System.out.println("║ 5. Pattern Integration Demo            ║");
        System.out.println("║ 6. Decorator Pattern Demo              ║");
        System.out.println("║ 7. Facade Pattern Demo                 ║");
        System.out.println("║ 8. Exit                                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    private static void createCustomWorkout() {
        System.out.println("\nCREATE CUSTOM WORKOUT");
        System.out.println("═══════════════════════════════════════");

        System.out.print("Enter workout name: ");
        String workoutName = scanner.nextLine();

        System.out.print("Enter difficulty (Beginner/Intermediate/Advanced): ");
        String difficulty = scanner.nextLine();

        System.out.print("How many exercises do you want to add? ");
        int numExercises = scanner.nextInt();
        scanner.nextLine();

        List<Exercise> exercises = new ArrayList<>();

        for (int i = 1; i <= numExercises; i++) {
            System.out.println("\n--- Exercise " + i + " ---");
            System.out.print("Enter exercise type (cardio/strength/yoga/stretching): ");
            String type = scanner.nextLine();

            System.out.print("Enter exercise name: ");
            String name = scanner.nextLine();

            Exercise exercise = exerciseFactory.createQuickExercise(type, name);

            // Ask if user wants to add decorators
            System.out.print("Add time constraint? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter duration in seconds: ");
                int duration = scanner.nextInt();
                scanner.nextLine();
                exercise = new TimedExercise(exercise, duration);
            }

            System.out.print("Add weight? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter weight in kg: ");
                double weight = scanner.nextDouble();
                scanner.nextLine();
                exercise = new WeightedExercise(exercise, weight);
            }

            if (exercise != null) {
                exercises.add(exercise);
                System.out.println("Exercise added successfully!");
            }
        }

        if (exercises.isEmpty()) {
            System.out.println("No exercises added. Cannot create workout.");
            return;
        }

        System.out.print("\nEnter number of sets: ");
        int sets = scanner.nextInt();

        System.out.print("Enter number of reps: ");
        int reps = scanner.nextInt();

        System.out.print("Enter rest time between sets (seconds): ");
        int restTime = scanner.nextInt();

        System.out.print("Enter total workout duration (minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        try {
            WorkoutPlan plan = new WorkoutPlanBuilder()
                    .setName(workoutName)
                    .setDifficulty(difficulty)
                    .addExercises(exercises)
                    .setSets(sets)
                    .setReps(reps)
                    .setRestTime(restTime)
                    .setDuration(duration)
                    .setDescription("Custom workout created by user")
                    .build();

            System.out.println("\nWorkout plan created successfully!");
            plan.displayPlan();

            System.out.println("\nExercise Details:");
            for (Exercise ex : exercises) {
                ex.perform();
            }

        } catch (IllegalStateException e) {
            System.out.println("Error creating workout: " + e.getMessage());
        }
    }

    private static void usePreBuiltWorkout() {
        System.out.println("\nPRE-BUILT WORKOUTS");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. Beginner Full Body");
        System.out.println("2. Intermediate Total Body");
        System.out.println("3. Advanced Athlete Training");
        System.out.println("4. Cardio Blast");
        System.out.println("5. Strength Builder");
        System.out.print("\nChoose a workout: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        WorkoutPlan plan = null;

        switch (choice) {
            case 1:
                plan = director.constructBeginnerPlan();
                break;
            case 2:
                plan = director.constructIntermediatePlan();
                break;
            case 3:
                plan = director.constructAdvancedPlan();
                break;
            case 4:
                plan = director.constructCardioPlan();
                break;
            case 5:
                plan = director.constructStrengthPlan();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (plan != null) {
            System.out.println("\nWorkout loaded successfully!");
            plan.displayPlan();
        }
    }

    private static void demonstrateFactory() {
        System.out.println("\nFACTORY PATTERN DEMONSTRATION");
        System.out.println("═══════════════════════════════════════");
        System.out.println("The Factory Pattern creates different exercise types without exposing the creation logic.\n");

        System.out.println("Creating 4 different exercise types...\n");

        Exercise cardio = exerciseFactory.createQuickExercise("cardio", "Running");
        Exercise strength = exerciseFactory.createQuickExercise("strength", "Bench Press");
        Exercise yoga = exerciseFactory.createQuickExercise("yoga", "Downward Dog");
        Exercise stretching = exerciseFactory.createQuickExercise("stretching", "Hamstring Stretch");

        cardio.perform();
        strength.perform();
        yoga.perform();
        stretching.perform();

        System.out.println("\nFactory Pattern creates objects dynamically!");
        System.out.println("Benefit: Adding new exercise types is easy - just extend Exercise interface");
    }

    private static void demonstrateBuilder() {
        System.out.println("\nBUILDER PATTERN DEMONSTRATION");
        System.out.println("═══════════════════════════════════════");
        System.out.println("The Builder Pattern constructs complex objects step-by-step with a clean, readable syntax.\n");

        Exercise ex1 = exerciseFactory.createQuickExercise("cardio", "Running");
        Exercise ex2 = exerciseFactory.createQuickExercise("strength", "Push-ups");
        Exercise ex3 = exerciseFactory.createQuickExercise("yoga", "Warrior Pose");

        System.out.println("Building workout plan step-by-step...\n");

        WorkoutPlan plan = new WorkoutPlanBuilder()
                .setName("Builder Demo Workout")
                .setDifficulty("Intermediate")
                .setDescription("Demonstrating the Builder Pattern")
                .addExercise(ex1)
                .addExercise(ex2)
                .addExercise(ex3)
                .setSets(3)
                .setReps(10)
                .setRestTime(60)
                .setDuration(40)
                .build();

        plan.displayPlan();

        System.out.println("\nBuilder Pattern creates complex objects elegantly!");
        System.out.println("Benefit: Code is readable, flexible, and maintainable");
    }

    private static void demonstrateIntegration() {
        System.out.println("\nPATTERN INTEGRATION DEMONSTRATION");
        System.out.println("═══════════════════════════════════════");

        System.out.println("\nFactory creates exercises:");
        Exercise ex1 = exerciseFactory.createQuickExercise("cardio", "Running");
        Exercise ex2 = exerciseFactory.createQuickExercise("strength", "Squats");
        System.out.println("   " + ex1.getName() + " (" + ex1.getType() + ")");
        System.out.println("   " + ex2.getName() + " (" + ex2.getType() + ")");

        System.out.println("\nBuilder constructs WorkoutPlan:");
        WorkoutPlan plan = new WorkoutPlanBuilder()
                .setName("Integration Demo")
                .addExercise(ex1)
                .addExercise(ex2)
                .setSets(3)
                .setReps(12)
                .build();
        System.out.println("   " + plan.getSummary());

        System.out.println("\nAll patterns work together seamlessly!");
    }

    private static void demonstrateFacadeDemo() {
        System.out.println("\nFACADE PATTERN DEMONSTRATION");
        System.out.println("═══════════════════════════════════════");

        WorkoutStrategy strategy = new FatBurnStrategy();

        Exercise exercise = exerciseFactory.createQuickExercise("cardio", "Running");

        WorkoutFacade facade = new WorkoutFacade(strategy, exercise);

        facade.startWorkout();
    }

    private static void demonstrateDecorator() {
        System.out.println("\nDECORATOR PATTERN DEMONSTRATION");
        System.out.println("═══════════════════════════════════════");
        System.out.println("The Decorator Pattern adds functionality to exercises dynamically.\n");

        System.out.println("1. Basic Push-ups Exercise:");
        Exercise pushups = exerciseFactory.createQuickExercise("strength", "Push-ups");
        pushups.perform();

        System.out.println("\n2. Adding Time constraint (60 seconds):");
        Exercise timedPushups = new TimedExercise(pushups, 60);
        timedPushups.perform();

        System.out.println("\n3. Adding Weight constraint (+5kg):");
        Exercise weightedTimedPushups = new WeightedExercise(timedPushups, 5);
        weightedTimedPushups.perform();

        System.out.println("\n4. Creating complex decorated exercise:");
        Exercise complexExercise = new WeightedExercise(
                new TimedExercise(
                        exerciseFactory.createQuickExercise("strength", "Squats"),
                        90
                ),
                10
        );
        complexExercise.perform();


        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      INTERACTIVE DECORATOR DEMO        ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("Choose base exercise (pushups/squats/lunges): ");
        String baseName = scanner.nextLine();

        Exercise baseExercise = exerciseFactory.createQuickExercise("strength", baseName);
        Exercise currentExercise = baseExercise;

        boolean decorating = true;
        while (decorating) {
            System.out.println("\nCurrent exercise: " + currentExercise.getDetails());
            System.out.println("1. Add time constraint");
            System.out.println("2. Add weight");
            System.out.println("3. Finish decorating");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter duration in seconds: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    currentExercise = new TimedExercise(currentExercise, duration);
                    System.out.println("✓ Time constraint added!");
                    break;
                case 2:
                    System.out.print("Enter weight in kg: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine();
                    currentExercise = new WeightedExercise(currentExercise, weight);
                    System.out.println("✓ Weight added!");
                    break;
                case 3:
                    decorating = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }


        System.out.println("\nFinal decorated exercise:");
        System.out.println("Description: " + currentExercise.getDetails());
        System.out.println("\nPerforming final exercise:");
        currentExercise.perform();

        System.out.println("\nDecorator Pattern allows dynamic functionality addition!");
        System.out.println("Benefit: Extend functionality without modifying original classes");
    }
}