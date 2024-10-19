package Logic;

class PetStat {
    private var value: Int

    companion object {
        const val MIN_VALUE: Int = 1
        const val MAX_VALUE: Int = 100
    }

    constructor() {
        value = MIN_VALUE
    }

    constructor(currentValue: Int) {
        if (currentValue > MAX_VALUE || currentValue < MIN_VALUE) {
            throw RuntimeException("Failed to create a new pet: incorrect stats, check min and max values");
        }
        value = currentValue
    }

    fun getValue(): Int {
        return value
    }

    fun increaseValue(amount: Int) {
        value = if (value + amount > MAX_VALUE) {
            MAX_VALUE
        } else {
            value + amount
        }
    }

    fun decreaseValue(amount: Int) {
        value = if (value - amount < MIN_VALUE) {
            MIN_VALUE
        } else {
            value - amount
        }
    }
}
