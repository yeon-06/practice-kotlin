package domain

import util.RandomUtil

class MoveStrategy {

    fun move(car: Car) {
        val randomValue = RandomUtil.generateRandom()
        if (randomValue >= STANDARD_VALUE) {
            car.move()
        }
    }

    companion object {
        private const val STANDARD_VALUE = 4
    }
}
