package Logic;

public class Pet {
    private int fullness;
    private String name;
    private int age;
    private String breed;

    public Pet(String name, int age, String breed, int currentFullness) {
        if (currentFullness < 1 || currentFullness > 50) {
            throw new RuntimeException("Invalid fullness value " + currentFullness);
        }
        fullness = currentFullness;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public int getFullness() {
        return fullness;
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
