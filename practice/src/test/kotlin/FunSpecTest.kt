import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FunSpecTest : FunSpec({
    test("글자수 검증") {
        "hello".length shouldBe 5
    }

    xtest("실행되지 않는 테스트") {
        "hello".length shouldBe 3
    }

    context("문자열의") {
        val string = "hello"

        test("글자수가 5이다") {
            string.length shouldBe 5
        }

        test("첫 글자는 h이다") {
            string.first() shouldBe 'h'
        }
    }
})
