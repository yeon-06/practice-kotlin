package domain

class Cars(names: List<String>) {

    val value: List<Car>

    init {
        require(names.distinct().size == names.size) { "자동차 이름 목록에 중복이 존재합니다." }
        value = names.map { Car(it) }
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
