package Logic;

public class Pet {
    private int fullness;
    private int cleanliness;
    private int energy;
    private int happiness;
    private String name;
    private int age;
    private String breed;

    public Pet(
            String name,
            int age,
            String breed,
            int currentFullness,
            int currentCleanliness,
            int currentEnergy,
            int currentHappiness) {
        if (currentFullness < 1 || currentFullness > 50) {
            throw new RuntimeException("Invalid fullness value " + currentFullness);
        }
        fullness = currentFullness;
        cleanliness = currentCleanliness;
        energy = currentEnergy;
        happiness = currentHappiness;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public int getFullness() {
        return fullness;
    }

    public void restoreFullness(int amount) {
        fullness += amount;
    }

    public void decreaseFullness(int amount) {
        fullness -= amount;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void restoreCleanliness(int amount) {
        cleanliness += amount;
    }

    public void decreaseCleanliness(int amount) {
        cleanliness -= amount;
    }

    public int getEnergy() {
        return energy;
    }

    public void restoreEnergy(int amount) {
        energy += amount;
    }

    public void decreaseEnergy(int amount) {
        energy -= amount;
    }

    public int getHappiness() {
        return happiness;
    }

    public void restoreHappiness(int amount) {
        happiness += amount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }
}
