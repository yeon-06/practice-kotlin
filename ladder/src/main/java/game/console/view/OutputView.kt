package game.console.view

import game.console.Ladder

object OutputView {

    private const val TAB_SIZE = 5

    fun printException(e: Exception) {
        println(e.message)
    }

    fun printLadder(ladder: Ladder) {
        println("사다리 결과")
        printListWithFormat(ladder.participantNames)
        printBoard(ladder.value)
        printListWithFormat(ladder.itemNames)
    }

    fun printResult(item: String) {
        println(item)
    }

    private fun printListWithFormat(list: List<String>) {
        for (l in list) {
            print("%-${TAB_SIZE}s".format(l))
        }
        println()
    }

    private fun printBoard(values: List<List<Boolean>>) {
        for (value in values) {
            print("|")
            for (v in value) {
                if (v) {
                    print("-".repeat(TAB_SIZE - 1))
                } else {
                    print(" ".repeat(TAB_SIZE - 1))
                }
                print("|")
            }
            println()
        }
    }
}
