package domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarTest : ShouldSpec({

    context("자동차 생성 시") {
        context("이름이 공백이면") {
            should("예외가 발생한다") {
                val names = listOf("", " ", "   ")
                names.forAll {
                    val exception = shouldThrow<Exception> { Car(it) }
                    exception.message.shouldBe("자동차 이름은 공백이 될 수 없습니다.")
                }
            }
        }

        context("이름 길이가 5자가 넘는다면") {
            should("예외가 발생한다") {
                val exception = shouldThrow<Exception> { Car("123456") }
                exception.message.shouldBe("자동차 이름의 길이는 5자 이하여야 합니다.")
            }
        }

        should("정상적으로 생성된다") {
            shouldNotThrowAny { Car("12345") }
        }
    }
})
