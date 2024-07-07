package com.yeonlog.practice

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 목표: 단일 스레드일 때와 멀티 스레드일 때, 코루틴이 어떤 스레드에서 실행되는지 확인해본다.
suspend fun main() {
    launchWithMultiThread()
}

private fun launchWithSingleThread() = runBlocking { // runBlocking은 현재 스레드를 블록한다 -> 하나의 스레드를 사용하게 됨
    val job = launch { // 새로운 코루틴을 생성 -> 비동기적으로 실행 가능하지만 현재 스레드는 1개뿐이고, 메인함수 실행에 사용되므로 launch 내의 코드가 곧바로 실행되지는 않음
        println("1 ${Thread.currentThread().name}")
        delay(1000)
        println("2 ${Thread.currentThread().name}")
    }
    println("3 ${Thread.currentThread().name}") // 따라서 가장 먼저 출력되는 것은 이 부분!
    job.join()
    println("4 ${Thread.currentThread().name}")
}

private suspend fun launchWithMultiThread() {
    val job = GlobalScope.launch {
        println("1 ${Thread.currentThread().name}") // 첫번째로 출력될 수 있는 문장 - 실행할 때마다 다름
        delay(1000)
        println("2 ${Thread.currentThread().name}")
    }
    GlobalScope.launch {
        println("1-1 ${Thread.currentThread().name}") // 첫번째로 출력될 수 있는 문장 - 실행할 때마다 다름
        delay(100)
        println("2-2 ${Thread.currentThread().name}")
    }
    println("3 ${Thread.currentThread().name}") // 첫번째로 출력될 수 있는 문장 - 실행할 때마다 다름
    job.join()
    println("4 ${Thread.currentThread().name}")
}
