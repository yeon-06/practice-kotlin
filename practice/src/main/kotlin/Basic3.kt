class Number {
    var value: Int = 0
        private set

    fun add(addValue: Int) {
        value += addValue
    }

    override fun toString(): String {
        return String.format("%s(value=%d)", javaClass.name, value)
    }
}

data class NumberData(
        var value: Int = 0
) {

    fun add(addValue: Int) {
        value += addValue
    }
}

fun main() {
    val number = Number()
//    number.value = 10 -> setter가 private라 오류가 발생한다
    number.add(10)
    println(number.value)

    // 재정의한 toString 호출
    println(number)

    // data class 로 정의하면 toString 자동으로 재정의
    val numberData = NumberData()
    println(numberData)

    // data class 로 정의하면 equals, hashCode 자동으로 재정의
    val numberData2 = NumberData(10)
    numberData.add(10)
    println("numberData: $numberData")
    println("numberData2: $numberData2")
    println(numberData == numberData2)
}
