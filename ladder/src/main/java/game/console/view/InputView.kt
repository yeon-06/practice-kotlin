package game.console.view

import game.console.validator.InputValidator

object InputView {

    fun inputParticipantNames(): List<String> {
        println("참가자 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)")
        return try {
            val participantNames = readln().split(",").map { it.trim() }
            InputValidator.validParticipantNames(participantNames)
            participantNames
        } catch (e: Exception) {
            OutputView.printException(e)
            inputParticipantNames()
        }
    }

    fun inputItemNames(itemCount: Int): List<String> {
        println("아이템 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)")
        return try {
            val itemNames = readln().split(",").map { it.trim() }
            InputValidator.validItemNames(itemCount, itemNames)
            itemNames
        } catch (e: Exception) {
            OutputView.printException(e)
            inputItemNames(itemCount)
        }
    }

    fun inputLadderHeight(): Int {
        println("최대 사다리 높이는 몇 개인가요?")
        return try {
            val input = readln()
            InputValidator.validLadderHeight(input)
            input.toInt()
        } catch (e: Exception) {
            OutputView.printException(e)
            inputLadderHeight()
        }
    }

    fun inputPartitionName(): String {
        println("결과를 보고 싶은 사람은?")
        return readln().trim()
    }
}
