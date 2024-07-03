package Logic;

public class Pet {
    private PetStat fullness;
    private PetStat cleanliness;
    private PetStat energy;
    private PetStat happiness;
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
        fullness = new PetStat(currentFullness);
        cleanliness = new PetStat(currentCleanliness);
        energy = new PetStat(currentEnergy);
        happiness = new PetStat(currentHappiness);
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public int getFullness() {
        return fullness.getValue();
    }

    public void restoreFullness(int amount) {
        fullness.increaseValue(amount);
    }

    public void decreaseFullness(int amount) {
        fullness.decreaseValue(amount);
    }

    public int getCleanliness() {
        return cleanliness.getValue();
    }

    public void restoreCleanliness(int amount) {
        cleanliness.increaseValue(amount);
    }

    public void decreaseCleanliness(int amount) {
        cleanliness.decreaseValue(amount);
    }

    public int getEnergy() {
        return energy.getValue();
    }

    public void restoreEnergy(int amount) {
        energy.increaseValue(amount);
    }

    public void decreaseEnergy(int amount) {
        energy.decreaseValue(amount);
    }

    public int getHappiness() {
        return happiness.getValue();
    }

    public void restoreHappiness(int amount) {
        happiness.increaseValue(amount);
    }

    public void decreaseHappiness(int amount) {
        happiness.decreaseValue(amount);
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
