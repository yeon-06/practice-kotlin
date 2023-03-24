package game.console

import game.console.util.RandomUtil

class Ladder(
        participantNames: List<String>,
        itemNames: List<String>,
        height: Int
) {

    val value: List<List<Boolean>>

    init {
        this.value = generateLadder(participantNames.size - 1, height)
    }

    private fun generateLadder(width: Int, height: Int): List<List<Boolean>> {
        val ladder = arrayListOf<List<Boolean>>()
        for (i in 1..height) {
            ladder.add(generateRow(width))
        }
        return ladder
    }

    private fun generateRow(width: Int): List<Boolean> {
        val row = arrayListOf<Boolean>()
        for (i in 1..width) {
            row.add(RandomUtil.generateRandom())
        }
        return row
    }
}
