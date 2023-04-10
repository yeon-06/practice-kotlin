package game.console.domain

import game.console.util.RandomUtil

class Ladder(
        participantNames: List<String>,
        itemNames: List<String>,
        height: Int
) {

    val participantNames: List<String>
    val itemNames: List<String>
    val value: List<List<Boolean>>

    init {
        this.participantNames = participantNames
        this.itemNames = itemNames
        this.value = generateLadder(participantNames.size - 1, height)
    }

    fun findItemByParticipant(participant: String): String {
        require(participantNames.contains(participant)) { "참가자의 이름을 올바르게 입력해주세요." }
        val startPoint = participantNames.indexOf(participant)
        return itemNames[findEndPointByStartPoint(startPoint)]
    }

    private fun findEndPointByStartPoint(startPoint: Int): Int {
        val height = value.size
        val width = value[0].size
        var nowPoint = startPoint
        for (nowHeight in 0 until height) {
            if (nowPoint > 0 && value[nowHeight][nowPoint - 1]) {
                nowPoint--
            } else if (nowPoint < width && value[nowHeight][nowPoint]) {
                nowPoint++
            }
        }
        return nowPoint
    }

    private fun generateLadder(width: Int, height: Int): List<List<Boolean>> {
        val ladder = mutableListOf<List<Boolean>>()
        for (i in 0 until height) {
            ladder.add(generateRow(width))
        }
        return ladder
    }

    private fun generateRow(width: Int): List<Boolean> {
        val row = mutableListOf<Boolean>()
        for (i in 0 until width) {
            var value = RandomUtil.generateRandom()
            if (i > 0 && row[i - 1]) {
                value = false
            }
            row.add(value)
        }
        return row
    }
}
