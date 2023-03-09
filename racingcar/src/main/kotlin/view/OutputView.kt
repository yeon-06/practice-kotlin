package view

import domain.Cars

object OutputView {

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printStatus(cars: Cars) {
        cars.value.forEach {
            println("${it.name} : ${drawStatusBar(it.location)}")
        }
        println()
    }

    private fun drawStatusBar(value: Int): String {
        return "-".repeat(value)
    }

    fun printResult(names: List<String>) {
        println("${names.joinToString(separator = ", ")}가 최종 우승했습니다.")
    }

    fun printException(exception: Exception) {
        println(exception.message)
    }
}
