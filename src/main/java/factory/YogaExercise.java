package factory;


public class YogaExercise implements Exercise {

    private String name;
    private String poseType;
    private int holdDuration;
    private String breathingTechnique;

    public YogaExercise(String name, String poseType, int holdDuration, String breathingTechnique) {
        this.name = name;
        this.poseType = poseType;
        this.holdDuration = holdDuration;
        this.breathingTechnique = breathingTechnique;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Yoga";
    }

    @Override
    public int getCalories() {

        return (int) (holdDuration * 0.1);
    }

    @Override
    public String getDetails() {
        return String.format("Pose: %s, Hold: %d seconds, Breathing: %s",
                poseType, holdDuration, breathingTechnique);
    }

    @Override
    public void perform() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║          YOGA EXERCISE                 ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("  Exercise: " + name);
        System.out.println("  Type: " + getType());
        System.out.println("  " + getDetails());
        System.out.println("  Calories: ~" + getCalories() + " kcal");
        System.out.println("╚════════════════════════════════════════╝");
    }


    public String getPoseType() { return poseType; }
    public int getHoldDuration() { return holdDuration; }
    public String getBreathingTechnique() { return breathingTechnique; }
}
