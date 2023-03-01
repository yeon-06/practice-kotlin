package view

import domain.Cars
import java.lang.Exception

object OutputView {

    fun printStartSentence() {
        println("실행 결과")
    }

    fun printStatus(cars: Cars) {
        cars.value.forEach {
            println(String.format("%s : %s", it.name, drawStatusBar(it.location)))
        }
    }

    private fun drawStatusBar(value: Int): String {
        return "-".repeat(value)
    }

    fun printResult(names: List<String>) {
        println(
                String.format("%s가 최종 우승했습니다.", names.joinToString(separator = ", "))
        )
    }

    fun printException(exception: Exception) {
        println(exception.message)
    }
}
