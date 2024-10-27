import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BehaviorSpecTest : BehaviorSpec({
    given("문자열에서") {
        val string = "hello"

        `when`("글자수를 확인하면") {
            val result = string.length

            then("글자수는 5이다") {
                result shouldBe 5
            }
        }
    }
})
