package factory;

public class StrengthExercise implements Exercise {

    private String name;
    private double weight;
    private int repetitions;
    private String muscleGroup;

    public StrengthExercise(String name, double weight, int repetitions, String muscleGroup) {
        this.name = name;
        this.weight = weight;
        this.repetitions = repetitions;
        this.muscleGroup = muscleGroup;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Strength";
    }

    @Override
    public int getCalories() {
        return (int) (weight * repetitions * 0.1);
    }

    @Override
    public String getDetails() {
        return String.format("Weight: %.1f kg, Reps: %d, Target: %s",
                weight, repetitions, muscleGroup);
    }

    @Override
    public void perform() {
        System.out.println("Exercise: " + name);
        System.out.println("Type: " + getType());
        System.out.println(getDetails());
        System.out.println("Calories: ~" + getCalories() + " kcal");
    }

    public double getWeight() {
        return weight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }
}
