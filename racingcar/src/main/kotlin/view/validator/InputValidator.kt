package view.validator

object InputValidator {

    fun validTryCount(input: String) {
        require(isNumber(input)) { "시도 횟수는 숫자 형태로 입력해야합니다." }
        require(input.toInt() >= 0) { "시도 횟수는 0이상이어야 합니다." }
    }

    private fun isNumber(input: String): Boolean =
            input.toIntOrNull() != null
}
