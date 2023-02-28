package domain

import java.util.stream.Collectors

class Cars(names: List<String>) {

    private val value: List<Car>

    init {
        validateNames(names)
        value = names.stream()
                .map { Car(it) }
                .collect(Collectors.toList())
    }

    private fun validateNames(names: List<String>) {
        val nameSet = setOf(names)
        if (nameSet.size != names.size) {
            throw IllegalArgumentException("자동차 이름 목록에 중복이 존재합니다.")
        }
    }

    fun moveAll() {
        value.forEach { it.move() }
    }
}
