import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

class FeatureSpecTest : FeatureSpec({
    feature("String.length") {
        scenario("hello의 글자수는 5이다") {
            "hello".length shouldBe 5
        }

        xscenario("실행되지 않는 테스트 케이스") {
            "hello".length shouldBe 1
        }
    }
})
