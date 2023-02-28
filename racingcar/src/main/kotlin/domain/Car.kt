package domain

import util.RandomUtil

class Car(
        val name: String,
        var location: Int = 0
) {

    init {
        require(name.isNotBlank()) { "자동차 이름은 공백이 될 수 없습니다." }
        require(name.length <= 5) { "자동차 이름의 길이는 5자 이하여야 합니다." }
    }

    fun move() {
        val randomValue = RandomUtil.generateRandom()
        if (randomValue >= 4) {
            location++
        }
    }
}
