package domain

class Car(
        val name: String, location: Int = 0
) {
    var location = location
        private set

    init {
        require(name.isNotBlank()) { "자동차 이름은 공백이 될 수 없습니다." }
        require(name.length <= 5) { "자동차 이름의 길이는 5자 이하여야 합니다." }
    }

    fun move() {
        location++
    }
}
