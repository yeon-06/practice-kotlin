package com.yeonlog.practice

import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
    launchTest()
    asyncTest()
}

private suspend fun launchTest() = coroutineScope {
    val l = launch {
//        delay(1000L)
        println("launch")
    }
    println("===== launch")
    printStatus(l)
    println("===== launch join")
    l.join()
    printStatus(l)
}

private suspend fun asyncTest() = coroutineScope {
    val a = async {
//        delay(1000L)
        println("async")
    }
    println("===== async")
    printStatus(a)
    println("===== async await")
    println(a.await())
    printStatus(a)
}

private fun printStatus(job: Job) {
    println(
        """
        isActive: ${job.isActive}
        isCancelled: ${job.isCancelled}
        isCompleted: ${job.isCompleted}
    """.trimIndent()
    )
}
