import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class CoroutineContextTest {

    @Test
    fun launch_인자에_context_넘기기() = runTest {
        println(Thread.currentThread().name)

        val context = newSingleThreadContext("myThreadContext") + CoroutineName("myCoroutineName")
        launch(context = context) {
            println(Thread.currentThread().name)
        }

        /* Output
            Test worker @kotlinx.coroutines.test runner#3
            myThreadContext @myCoroutineName#4
         */
    }

    @Test
    fun context_덮어씌우기() = runTest {
        println(Thread.currentThread().name)

        val context = newSingleThreadContext("myThreadContext") + CoroutineName("myCoroutineName")

        val newContext1 = CoroutineName("beforeCoroutineName") + context
        launch(context = newContext1) {
            println(Thread.currentThread().name)
        }

        val newContext2 = context + CoroutineName("afterCoroutineName")
        launch(context = newContext2) {
            println(Thread.currentThread().name)
        }

        /* Output - 같은 구성 요소에 대해 여러 객체가 입력되면 나중의 값이 덮어씌워짐
            Test worker @kotlinx.coroutines.test runner#3
            myThreadContext @myCoroutineName#4
            myThreadContext @afterCoroutineName#5
         */
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun CoroutineContext_구성요소() = runTest {
        val context = CoroutineName("myCoroutineName") + Dispatchers.IO + Job()
        println("CoroutineName -> ${context[CoroutineName.Key]}")
        println("CoroutineDispatcher -> ${context[CoroutineDispatcher.Key]}")
        println("CoroutineExceptionHandler -> ${context[CoroutineExceptionHandler.Key]}")
        println("Job -> ${context[Job.Key]}")
    }
}
