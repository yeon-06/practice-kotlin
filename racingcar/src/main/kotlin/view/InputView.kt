package view

import exception.InputException

object InputView {

    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(",")
    }

    fun inputTryCount(): Int {
        try {
            println("시도할 회수는 몇회인가요?")
            return readln().toInt()
        } catch (e: NumberFormatException) {
            throw InputException("시도 횟수는 숫자 형태로 입력해야합니다.")
        }
    }
}