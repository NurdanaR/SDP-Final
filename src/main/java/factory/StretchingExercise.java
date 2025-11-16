package factory;


public class StretchingExercise implements Exercise {

    private String name;
    private String targetArea;
    private int holdTime;
    private String flexibilityLevel;

    public StretchingExercise(String name, String targetArea, int holdTime, String flexibilityLevel) {
        this.name = name;
        this.targetArea = targetArea;
        this.holdTime = holdTime;
        this.flexibilityLevel = flexibilityLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Stretching";
    }

    @Override
    public int getCalories() {
        // Simple calculation: hold time * 0.05 (stretching burns fewer calories)
        return (int) (holdTime * 0.05);
    }

    @Override
    public String getDetails() {
        return String.format("Target: %s, Hold: %d seconds, Level: %s",
                targetArea, holdTime, flexibilityLevel);
    }

    @Override
    public void perform() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       STRETCHING EXERCISE              ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("  Exercise: " + name);
        System.out.println("  Type: " + getType());
        System.out.println("  " + getDetails());
        System.out.println("  Calories: ~" + getCalories() + " kcal");
        System.out.println("╚════════════════════════════════════════╝");
    }

    public String getTargetArea() { return targetArea; }
    public int getHoldTime() { return holdTime; }
    public String getFlexibilityLevel() { return flexibilityLevel; }
}
