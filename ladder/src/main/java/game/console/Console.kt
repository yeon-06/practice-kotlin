package game.console

import game.console.domain.Ladder
import game.console.view.InputView
import game.console.view.OutputView

fun main() {
    val participantNames = InputView.inputParticipantNames()
    val itemNames = InputView.inputItemNames(participantNames.size)
    val ladderHeight = InputView.inputLadderHeight()

    val ladder = Ladder(participantNames, itemNames, ladderHeight)
    OutputView.printLadder(ladder)

    var input = InputView.inputPartitionName()
    while (!input.contentEquals("q")) {
        printResult(ladder, input)
        input = InputView.inputPartitionName()
    }
}

private fun printResult(ladder: Ladder, participant: String) {
    try {
        OutputView.printResult(ladder.findItemByParticipant(participant))
    } catch (e:Exception) {
        OutputView.printException(e)
    }
}
