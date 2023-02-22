class Number {
    var value: Int = 0
        private set

    fun add(addValue: Int) {
        value += addValue
    }
}

fun main() {
    val number = Number()
//    number.value = 10 -> setter가 private라 오류가 발생한다
    number.add(10)
    println(number.value)
}
