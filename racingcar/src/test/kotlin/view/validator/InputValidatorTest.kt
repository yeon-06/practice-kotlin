package view.validator

import exception.InputException
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class InputValidatorTest : ShouldSpec({

    context("시도 횟수가") {
        context("숫자가 아니라면") {
            val inputs = listOf("a", " ", "", "a12")

            should("예외가 발생한다.") {
                inputs.forAll {
                    val exception = shouldThrow<InputException> { InputValidator.validTryCount(it) }
                    exception.message.shouldBe("시도 횟수는 숫자 형태로 입력해야합니다.")
                }
            }
        }

        context("0 미만이라면") {
            val input = "-1"

            should("예외가 발생한다.") {
                val exception = shouldThrow<InputException> { InputValidator.validTryCount(input) }
                exception.message.shouldBe("시도 횟수는 0이상이어야 합니다.")
            }
        }

        context("정상적이라면") {
            val inputs = listOf("0", "1", "100")

            should("예외가 발생하지 않는다.") {
                inputs.forAll {
                    shouldNotThrowAny { InputValidator.validTryCount(it) }
                }
            }
        }
    }
})
