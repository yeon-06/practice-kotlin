import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringSpecTest : StringSpec({
    "글자수 검증" {
        "hello".length shouldBe 5
    }
})
