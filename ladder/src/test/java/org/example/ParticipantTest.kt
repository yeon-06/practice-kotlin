package org.example

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ParticipantTest : ShouldSpec({

    context("참가자 생성 시") {
        context("참가자 이름은") {
            should("비어있을 수 없다.") {
                shouldThrow<IllegalArgumentException> {
                    Participant("")
                }.message.shouldBe("참가자 이름은 공백이 될 수 없습니다.")
            }
            should("길이가 5자 초과할 수 없다.") {
                shouldThrow<IllegalArgumentException> {
                    Participant("123456")
                }.message.shouldBe("참가자 이름은 1자 이상, 5자 이하여야 합니다.")
            }
        }
    }
})
