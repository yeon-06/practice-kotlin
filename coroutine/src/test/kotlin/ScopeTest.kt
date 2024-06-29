import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test


class ScopeTest {
    @Test
    fun coroutineScope를_호출한_코루틴을_중단() = runTest {
        launch {
            delay(1000)
            println("coroutineScope 1")
        }
        launch {
            println("coroutineScope 2")
        }
        coroutineScope {
            launch {
                delay(100)
                println("coroutineScope 3")
            }
        }
        println("coroutineScope 4")

        /** 출력 결과
        coroutineScope 2
        coroutineScope 3
        coroutineScope 4
        coroutineScope 1
         */
    }

    @Test
    fun 자식에서_예외_발생_시_다른_자식들도_취소() = runTest {
        val job = launch {
            coroutineScope {
                launch {
                    delay(100)
                    println("자식 1")
                    throw RuntimeException()
                }
                launch {
                    delay(1000)
                    println("자식 2")
                }
            }
        }
        job.join()
    }

    @Test
    fun supervisorScope_예제() = runTest {
        // 컨텍스트의 Job을 SupervisorJob으로 오버라이딩 -> 자식 코루틴이 예외를 던져도 취소되지 않는다.
        supervisorScope {
            launch {
                println("launch 1")
                throw Error()
            }
            launch {
                delay(100)
                println("launch 2")
            }
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun withContext_예제() = runTest {
        println(coroutineContext[CoroutineDispatcher.Key])

        // 컨텍스트를 대체할 수 있다.
        withContext(Dispatchers.IO) {
            println(coroutineContext[CoroutineDispatcher.Key])
            launch { println(coroutineContext[CoroutineDispatcher.Key]) }
        }
    }

    @Test
    fun withTimeout_예제() = runTest {
        println("start")
        launch {
            withTimeout(1000) { // TimeoutCancellationException 발생
                launch {
                    delay(1000)
                    println("launch with delay")
                }
                launch {
                    println("launch without delay")
                }
            }
        }

        // withTimeout으로 인한 예외는 부모 코루틴에는 영향주지 않아 무사히 출력
        delay(1000)
        println("end")
    }
}
