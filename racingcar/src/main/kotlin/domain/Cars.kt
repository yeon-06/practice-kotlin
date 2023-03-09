package domain

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

    fun moveAll(strategy: MoveStrategy) {
        value.forEach { strategy.move(it) }
    }

    fun findMaxLocationCars(): List<Car> {
        val maxLocation = findMaxLocation()
        return value.filter { it.location == maxLocation }
    }

    private fun findMaxLocation(): Int =
            value.maxOf { it.location }
}
