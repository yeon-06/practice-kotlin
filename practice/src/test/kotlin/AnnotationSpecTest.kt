import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.Test
import io.kotest.matchers.shouldBe

class AnnotationSpecTest : AnnotationSpec() {
    @Test
    fun 글자수_검증() {
        "hello".length shouldBe 5
    }
}
