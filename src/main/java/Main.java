import Strategy.*;
import Observer.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== FITNESS APP =====");
        System.out.println("Choose workout strategy:");
        System.out.println("1 - Fat Burn");
        System.out.println("2 - Muscle Gain");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        WorkoutStrategy strategy;

        if (choice == 1) {
            strategy = new FatBurnStrategy();
        } else if (choice == 2) {
            strategy = new MuscleGainStrategy();
        } else {
            System.out.println("Invalid choice! Default Fat Burn Strategy selected.");
            strategy = new FatBurnStrategy();
        }

        System.out.println("\n=== Applying selected strategy ===");
        strategy.executeWorkout();

        // ==============================
        // Observer Part
        // ==============================

        Timer timer = new Timer();
        timer.attach(new CalorieCounter());
        timer.attach(new HeartRateMonitor());

        System.out.println("\n=== Starting workout session ===");
        timer.tick(10);
        timer.tick(20);
        timer.tick(30);

        scanner.close();
    }
}
