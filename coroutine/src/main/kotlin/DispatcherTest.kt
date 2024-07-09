package com.yeonlog.practice

import kotlinx.coroutines.*
import java.util.concurrent.Executors

suspend fun main() {
    unconfinedTest2()
}

suspend fun asCoroutineDispatcherTest() = coroutineScope {
    val dispatcher = Executors.newScheduledThreadPool(10).asCoroutineDispatcher()
    repeat(20) {
        launch(dispatcher) {
            Thread.sleep(1)
            println(Thread.currentThread().name)
        }
    }
    dispatcher.close()  // -> 여기서 close를 하지 않으면 프로그램이 종료되지 않는다.
}

suspend fun unconfinedTest() = coroutineScope {
    println(Thread.currentThread().name)
    launch(Dispatchers.Unconfined) { // 무제한 디스패처 사용
        println(Thread.currentThread().name)
    }
    launch {
        println(Thread.currentThread().name)
    }
}

suspend fun unconfinedTest2() = coroutineScope {
    println(Thread.currentThread().name)
    launch(Dispatchers.Unconfined) { // 무제한 디스패처 사용
        println(Thread.currentThread().name)
        delay(10)
        println(Thread.currentThread().name)
    }
}

