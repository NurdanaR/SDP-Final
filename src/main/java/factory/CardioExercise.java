package factory;

public class CardioExercise implements Exercise {

    private String name;
    private double distance;
    private double speed;
    private int duration;

    public CardioExercise(String name, double distance, double speed, int duration) {
        this.name = name;
        this.distance = distance;
        this.speed = speed;
        this.duration = duration;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Cardio";
    }

    @Override
    public int getCalories() {
        return (int) (distance * 50);
    }

    @Override
    public String getDetails() {
        return String.format("Distance: %.2f km, Speed: %.2f km/h, Duration: %d minutes",
                distance, speed, duration);
    }

    @Override
    public void perform() {
        System.out.println("Exercise: " + name);
        System.out.println("Type: " + getType());
        System.out.println(getDetails());
        System.out.println("Calories: ~" + getCalories() + " kcal");
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDuration() {
        return duration;
    }
}
