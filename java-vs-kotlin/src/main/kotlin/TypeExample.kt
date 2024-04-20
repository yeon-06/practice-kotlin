fun main() {
    printAsWithNullExample(1L)      // 1
    printAsWithNullExample(1)       // null
    printAsWithNullExample(null)    // null

    printAsExample(1L)              // 1
    printAsExample(1)               // ClassCastException
}

fun printAsWithNullExample(obj: Any?) {
    println(obj as? Long)
}

fun printAsExample(obj: Any) {
    println(obj as Long)
}
