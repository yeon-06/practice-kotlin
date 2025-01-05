package com.yeonlog.practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() {
    supervisorScopeTest()
}

private fun supervisorTest() = runBlocking {
    println("main start ${Thread.currentThread().name}")

    launch(SupervisorJob()) {
        println("launch start ${Thread.currentThread().name}")

        launch {
            delay(1000)
            println("launch Error 1 ${Thread.currentThread().name}")
            throw Error("Error 1")
        }

        launch { // not printed
            delay(2000)
            println("launch Error 2 ${Thread.currentThread().name}")
            throw Error("Error 2")
        }
        println("launch end ${Thread.currentThread().name}")
    }

    println("main before delay ${Thread.currentThread().name}")
    delay(3000)
    println("main end ${Thread.currentThread().name}")
}

private fun supervisorTest2() = runBlocking {
    println("main start ${Thread.currentThread().name}")

    // 테스트를 위해 선언하였으나, 하나의 job을 여러 코루틴에서 공유하는건 좋지 않다고 생각함
    val job = SupervisorJob()
    launch(job + Dispatchers.Default) {
        delay(1000)
        println("launch Error 1 ${Thread.currentThread().name}")
        throw Error("Error 1")
    }

    launch(job + Dispatchers.Default) {
        delay(2000)
        println("launch Error 2 ${Thread.currentThread().name}")
        throw Error("Error 2")
    }

    job.children.forEach { it.join() }
    /**
     * 아래 주석을 해제하면 애플리케이션이 종료되지 않는다.
     * SupervisorJob은 자식의 실패를 부모로 전파하지는 않지만 실패한 자식의 상태를 그대로 유지한다
     * 자식은 isCancelled = true, isCompleted = false인 상태가 된다
     * 나는 예외를 무시해도 될 때 SupervisorJob을 쓴다고 생각했는데 예외를 전파하지 않을 뿐, 예외 처리는 필요하다
     */
//    job.join() // 애플리케이션이 종료되지 않음. SupervisorJob의

    println("main before delay ${Thread.currentThread().name}")
    delay(3000)
    println("main end ${Thread.currentThread().name}")
}

private fun supervisorScopeTest() = runBlocking {
    /**
     * supervisorScope는 내부적으로 try - finally 블록을 사용해 자식 코루틴의 예외를 안전하게 처리
     * 그래서 SupervisorJob 때와는 달리 별도로 예외처리를 하지 않아도 애플리케이션이 잘 종료됨
     */
    supervisorScope {
        println("supervisorScope start ${Thread.currentThread().name}")

        launch(Dispatchers.Default) {
            delay(1000)
            println("launch Error 1 ${Thread.currentThread().name}")
            throw Error("Error 1")
        }

        launch(Dispatchers.Default) {
            delay(2000)
            println("launch Error 2 ${Thread.currentThread().name}")
            throw Error("Error 2")
        }

        println("supervisorScope before delay ${Thread.currentThread().name}")
        delay(3000)
        println("supervisorScope end ${Thread.currentThread().name}")
    }
}
