package game.console.validator

object InputValidator {

    private const val MIN_PARTICIPANT_SIZE = 2
    private const val MAX_PARTICIPANT_SIZE = 20
    private const val MIN_NAME_LENGTH = 1
    private const val MAX_NAME_LENGTH = 5
    private const val MIN_LADDER_HEIGHT = 1
    private const val MAX_LADDER_HEIGHT = 100

    fun validParticipantNames(participantNames: List<String>) {
        require(participantNames.size in MIN_PARTICIPANT_SIZE..MAX_PARTICIPANT_SIZE) { "참가자는 최소 ${MIN_PARTICIPANT_SIZE}명, 최대 ${MAX_PARTICIPANT_SIZE}명이어야 합니다." }
        require(participantNames.distinct().size == participantNames.size) { "참가자 이름은 중복이 불가능합니다." }
        require(participantNames.all { it.isNotBlank() }) { "공백은 참가자 이름이 될 수 없습니다." }
        require(participantNames.all { isValidNameLength(it) }) { "참가자 이름은 ${MIN_NAME_LENGTH}자 이상, ${MAX_NAME_LENGTH}자 이하여야 합니다." }
    }

    fun validItemNames(itemCount: Int, itemNames: List<String>) {
        require(itemCount == itemNames.size) { "아이템 개수가 맞지 않습니다." }
        require(itemNames.all { it.isNotBlank() }) { "공백은 아이템 이름이 될 수 없습니다." }
        require(itemNames.all { isValidNameLength(it) }) { "아이템 이름은 ${MIN_NAME_LENGTH}자 이상, ${MAX_NAME_LENGTH}자 이하여야 합니다." }
    }

    fun validLadderHeight(input: String) {
        require(input.toIntOrNull() != null) { "사다리 높이는 숫자로 입력해야 합니다." }
        require(input.toInt() in MIN_LADDER_HEIGHT..MAX_LADDER_HEIGHT) { "사다리 높이는 $MIN_LADDER_HEIGHT 이상, $MAX_LADDER_HEIGHT 이하여야 합니다." }
    }

    private fun isValidNameLength(name: String): Boolean {
        return name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH
    }
}
