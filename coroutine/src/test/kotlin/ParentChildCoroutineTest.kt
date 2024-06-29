import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.coroutines.CoroutineContext

class ParentChildCoroutineTest {

    @Test
    fun 부모_코루틴에서_컨텍스트_상속() = runTest {
        println("부모 코루틴")
        printCoroutineContext(coroutineContext)

        launch {
            println("자식 코루틴")
            printCoroutineContext(coroutineContext)
            println("parent's Job -> ${coroutineContext[Job.Key]?.parent}")
        }
    }

    @Test
    fun 부모_자식_코루틴_확인() = runTest(CoroutineName("coroutineTest")) {
        val parentJob = coroutineContext[Job.Key]

        launch {
            val childJob = coroutineContext[Job.Key]
            println("parentJob -> ${parentJob}")
            println("childJob -> ${childJob}")

            println("parentJob.children ${parentJob?.children?.iterator()?.next()}")
            println("childJob.parent ${childJob?.parent}")
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun printCoroutineContext(context: CoroutineContext) {
        println("CoroutineName -> ${context[CoroutineName.Key]}")
        println("CoroutineDispatcher -> ${context[CoroutineDispatcher.Key]}")
        println("CoroutineExceptionHandler -> ${context[CoroutineExceptionHandler.Key]}")
        println("Job -> ${context[Job.Key]}")
    }
}
