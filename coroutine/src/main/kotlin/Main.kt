package com.yeonlog.practice

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Hello")

    suspendCoroutine { continuation ->
        println("World")
        continuation.resume(Unit)
    }
    println("!")
}
