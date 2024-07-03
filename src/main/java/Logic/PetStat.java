package Logic;

public class PetStat {
    private int value;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 100;

    public PetStat(int currentValue) {
        if (currentValue > MAX_VALUE || currentValue < MIN_VALUE) {
            throw new RuntimeException(
                    "Failed to create a new pet: incorrect stats, check min and max values");
        }
        value = currentValue;
    }

    public int getValue() {
        return value;
    }

    public void increaseValue(int amount) {
        if (value + amount > MAX_VALUE) {
            value = MAX_VALUE;
        } else {
            value += amount;
        }
    }

    public void decreaseValue(int amount) {
        if (value - amount < MIN_VALUE) {
            value = MIN_VALUE;
        } else {
            value -= amount;
        }
    }
}
