package factory;

import java.util.Scanner;

public class ExerciseFactory {

    public Exercise createExercise(String type) {
        type = type.toLowerCase().trim();

        Scanner scanner = new Scanner(System.in);
        Exercise exercise = null;

        switch (type) {
            case "cardio":
                exercise = createCardioExercise(scanner);
                break;
            case "strength":
                exercise = createStrengthExercise(scanner);
                break;
            case "yoga":
                exercise = createYogaExercise(scanner);
                break;
            case "stretching":
                exercise = createStretchingExercise(scanner);
                break;
            default:
                System.out.println("Unknown exercise type: " + type);
                System.out.println("Available types: cardio, strength, yoga, stretching");
                return null;
        }
        return exercise;
    }

    private CardioExercise createCardioExercise(Scanner scanner) {
        System.out.print("Enter exercise name: ");
        String name = scanner.nextLine();

        System.out.print("Enter distance in km: ");
        double distance = scanner.nextDouble();

        System.out.print("Enter average speed in km/h: ");
        double speed = scanner.nextDouble();

        System.out.print("Enter duration in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        return new CardioExercise(name, distance, speed, duration);
    }

    private StrengthExercise createStrengthExercise(Scanner scanner) {
        System.out.print("Enter exercise name: ");
        String name = scanner.nextLine();

        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter repetitions: ");
        int reps = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter muscle group: ");
        String muscleGroup = scanner.nextLine();

        return new StrengthExercise(name, weight, reps, muscleGroup);
    }

    private YogaExercise createYogaExercise(Scanner scanner) {
        System.out.print("Enter pose name: ");
        String name = scanner.nextLine();

        System.out.print("Enter pose type: ");
        String poseType = scanner.nextLine();

        System.out.print("Enter hold duration in seconds: ");
        int holdDuration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter breathing technique: ");
        String breathing = scanner.nextLine();

        return new YogaExercise(name, poseType, holdDuration, breathing);
    }

    private StretchingExercise createStretchingExercise(Scanner scanner) {
        System.out.print("Enter stretch name: ");
        String name = scanner.nextLine();

        System.out.print("Enter target area: ");
        String targetArea = scanner.nextLine();

        System.out.print("Enter hold time in seconds: ");
        int holdTime = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter flexibility level: ");
        String level = scanner.nextLine();

        return new StretchingExercise(name, targetArea, holdTime, level);
    }

    public Exercise createQuickExercise(String type, String name) {
        type = type.toLowerCase().trim();

        switch (type) {
            case "cardio":
                return new CardioExercise(name, 5.0, 10.0, 30);
            case "strength":
                return new StrengthExercise(name, 50.0, 10, "Full Body");
            case "yoga":
                return new YogaExercise(name, "Standing", 60, "Deep");
            case "stretching":
                return new StretchingExercise(name, "Full Body", 30, "Beginner");
            default:
                return null;
        }
    }
}
