package game.console.view

import game.console.domain.Ladder

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
        println(list.joinToString("") { "%-${TAB_SIZE}s".format(it) })
    }

    private fun printBoard(values: List<List<Boolean>>) {
        for (value in values) {
            print("|")
            value.forEach {
                print(findSign(it).repeat(TAB_SIZE - 1) + "|")
            }
            println()
        }
    }

    private fun findSign(boolean: Boolean): String =
            if (boolean) {
                "-"
            } else {
                " "
            }

}
