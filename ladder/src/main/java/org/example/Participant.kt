package org.example

class Participant(
        val name: String, location: Int = 0
) {
    init {
        require(name.isNotBlank()) {"참가자 이름은 공백이 될 수 없습니다."}
        require(name.length in 1..5) { "참가자 이름은 1자 이상, 5자 이하여야 합니다." }
    }
}
