package Logic

class Pet(//primary constructor
    val name: String,
    var age: Int,
    var breed: String,
    currentFullness: Int,
    currentCleanliness: Int,
    currentEnergy: Int,
    currentHappiness: Int
) {//class' properties
    private var fullness: PetStat = PetStat(currentFullness)
    private var cleanliness: PetStat = PetStat(currentCleanliness)
    private var energy: PetStat = PetStat(currentEnergy)
    private var happiness: PetStat = PetStat(currentHappiness)

    fun getFullness(): Int {
        return fullness.getValue()
    }

    fun restoreFullness(amount: Int) {
        fullness.increaseValue(amount)
    }

    fun decreaseFullness(amount: Int) {
        fullness.decreaseValue(amount)
    }

    fun getCleanliness(): Int {
        return cleanliness.getValue()
    }

    fun restoreCleanliness(amount: Int) {
        cleanliness.increaseValue(amount)
    }

    fun decreaseCleanliness(amount: Int) {
        cleanliness.decreaseValue(amount)
    }

    fun getEnergy(): Int {
        return energy.getValue()
    }

    fun restoreEnergy(amount: Int) {
        energy.increaseValue(amount)
    }

    fun decreaseEnergy(amount: Int) {
        energy.decreaseValue(amount)
    }

    fun getHappiness(): Int {
        return happiness.getValue()
    }

    fun restoreHappiness(amount: Int) {
        happiness.increaseValue(amount)
    }

    fun decreaseHappiness(amount: Int) {
        happiness.decreaseValue(amount)
    }
}