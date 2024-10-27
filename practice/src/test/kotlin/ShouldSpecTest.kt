import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ShouldSpecTest : ShouldSpec({
    should("hello의 글자수는 5이다") {
        "hello".length shouldBe 5
    }

    xshould("실행되지 않는 테스트 케이스") {
        "hello".length shouldBe 1
    }

    context("context") {
        val string = "hello"
        should("hello의 글자수는 5이다") {
            string.length shouldBe 5
        }

        should("hello의 첫 글자는 h이다") {
            string.first() shouldBe 'h'
        }
    }
})
