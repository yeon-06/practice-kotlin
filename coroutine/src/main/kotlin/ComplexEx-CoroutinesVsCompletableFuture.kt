package com.yeonlog.practice

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CompletableFuture

fun main() = withCompletableFuture()

private fun withCoroutines() = runBlocking {
    val ids = listOf(1, 2, 3, 4, 5)

    val results = ids.map { id ->
        async {
            val content = downloadFile(id)
            processFile(content)
        }
    }
    val otherResult = async { otherTask() }

    results.awaitAll().forEach { println(it) }
    println(otherResult.await())
}

private fun withCompletableFuture() {
    val ids = arrayOf(1, 2, 3, 4, 5)

    val futures = Array(ids.size) { i ->
        val id = ids[i]
        CompletableFuture.supplyAsync { downloadFile(id) }
            .thenApply { content -> processFile(content) }
    }
    val otherFuture = CompletableFuture.supplyAsync { otherTask()}

    val allOf = CompletableFuture.allOf(*futures)
    allOf.get()

    for (future in futures) {
        println(future.get())
    }
    println(otherFuture.get())
}

private fun downloadFile(id: Int): String {
    // 파일 다운로드하는 로직
    return "File content for ID: $id"
}

private fun processFile(content: String): String {
    // 파일 수행하는 로직
    return "Processed: $content"
}

fun otherTask(): String {
    // 아무튼 무언가 작업을 하는 로직
    return "Other task"
}
