package game.console.validator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.throwable.shouldHaveMessage

class InputValidatorTest : ShouldSpec({

    context("참가자 이름 목록을 검증할 때") {
        should("중복이 있으면 예외 발생") {
            val names = listOf("1", "1")
            shouldThrow<IllegalArgumentException> {
                InputValidator.validParticipantNames(names)
            }.shouldHaveMessage("참가자 이름은 중복이 불가능합니다.")
        }

        should("참가자 수가 2명 미만이면 예외 발생") {
            val names = listOf("1")
            shouldThrow<IllegalArgumentException> {
                InputValidator.validParticipantNames(names)
            }.shouldHaveMessage("참가자는 최소 2명, 최대 20명이어야 합니다.")
        }

        should("참가자 수가 20명 초과면 예외 발생") {
            val names = listOf(1..21).map { it.toString() }
            shouldThrow<IllegalArgumentException> {
                InputValidator.validParticipantNames(names)
            }.shouldHaveMessage("참가자는 최소 2명, 최대 20명이어야 합니다.")
        }

        should("참가자 이름이 공백이면 예외 발생") {
            val names = listOf(" ", "1")
            shouldThrow<IllegalArgumentException> {
                InputValidator.validParticipantNames(names)
            }.shouldHaveMessage("공백은 참가자 이름이 될 수 없습니다.")
        }

        should("참가자 이름이 5자 초과면 예외 발생") {
            val names = listOf("123456", "1")
            shouldThrow<IllegalArgumentException> {
                InputValidator.validParticipantNames(names)
            }.shouldHaveMessage("참가자 이름은 1자 이상, 5자 이하여야 합니다.")
        }
    }

    context("아이템 이름을 검증할 때") {
        should("아이템 개수가 맞지 않으면 예외 발생") {
            val names = listOf("123456", "1")
            shouldThrow<IllegalArgumentException> {
                InputValidator.validItemNames(names.size - 1, names)
            }.shouldHaveMessage("아이템 개수가 맞지 않습니다.")
        }

        should("아이템 이름이 공백이라면 예외 발생") {
            val names = listOf("  ", "1")
            shouldThrow<IllegalArgumentException> {
                InputValidator.validItemNames(names.size, names)
            }.shouldHaveMessage("공백은 아이템 이름이 될 수 없습니다.")
        }

        should("아이템 이름이 5자 초과면 예외 발생") {
            val names = listOf("123456", "1")
            shouldThrow<IllegalArgumentException> {
                InputValidator.validItemNames(names.size, names)
            }.shouldHaveMessage("아이템 이름은 1자 이상, 5자 이하여야 합니다.")
        }
    }

    context("사다리 높이를 검증할 때") {
        should("문자를 입력하면 예외 발생") {
            shouldThrow<IllegalArgumentException> {
                InputValidator.validLadderHeight("hello")
            }.shouldHaveMessage("사다리 높이는 숫자로 입력해야 합니다.")
        }

        should("높이가 1 미만이라면 예외 발생") {
            shouldThrow<IllegalArgumentException> {
                InputValidator.validLadderHeight("0")
            }.shouldHaveMessage("사다리 높이는 1 이상, 100 이하여야 합니다.")
        }

        should("높이가 100 초과라면 예외 발생") {
            shouldThrow<IllegalArgumentException> {
                InputValidator.validLadderHeight("101")
            }.shouldHaveMessage("사다리 높이는 1 이상, 100 이하여야 합니다.")
        }
    }
})
