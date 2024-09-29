package com.yeonlog.practice

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

fun main() = withCompletableFuture()

private fun withCoroutines() = runBlocking {
    val deferred1 = async { taskWithCoroutines(1000L) }
    val deferred2 = async { taskWithCoroutines(2000L) }

    val result1 = deferred1.await()
    val result2 = deferred2.await()

    println("Result: ${result1 + result2}")
}

private suspend fun taskWithCoroutines(timeMillis: Long): Long {
    delay(timeMillis)
    return timeMillis
}


private fun withCompletableFuture() {
    val future1 = CompletableFuture.supplyAsync { taskWithCompletableFuture(1000L) }
    val future2 = CompletableFuture.supplyAsync { taskWithCompletableFuture(2000L) }

    try {
        val result1 = future1.get()
        val result2 = future2.get()
        println("Result: ${result1 + result2}")

    } catch (e: ExecutionException) {
        e.printStackTrace()

    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}

private fun taskWithCompletableFuture(timeMillis: Long): Long {
    Thread.sleep(timeMillis)
    return timeMillis
}
