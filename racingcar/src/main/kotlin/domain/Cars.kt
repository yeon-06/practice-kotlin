package domain

import util.RandomUtil

class Cars(names: List<String>) {

    val value: List<Car>

    init {
        validateNames(names)
        value = names.map { Car(it) }
    }

    private fun validateNames(names: List<String>) {
        val nameSet = names.toSet()
        if (nameSet.size != names.size) {
            throw IllegalArgumentException("자동차 이름 목록에 중복이 존재합니다.")
        }
    }

    fun moveAll() {
        value.forEach {
            val randomValue = RandomUtil.generateRandom()
            if (randomValue >= 4) {
                it.move()
            }
        }
    }

    fun findMaxLocationCars(): List<Car> {
        val maxLocation = findMaxLocation()
        return value.filter { it.location == maxLocation }
    }

    private fun findMaxLocation(): Int {
        return value.maxOf { it.location }
    }
}
