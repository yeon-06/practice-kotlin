package view.validator

import exception.InputException

object InputValidator {

    fun validTryCount(input: String) {
        if (isNumber(input)) {
            throw InputException("시도 횟수는 숫자 형태로 입력해야합니다.")
        }
        if (input.toInt() < 0) {
            throw InputException("시도 횟수는 0이상이어야 합니다.")
        }
    }

    private fun isNumber(input: String): Boolean {
        return input.toIntOrNull() != null
    }
}