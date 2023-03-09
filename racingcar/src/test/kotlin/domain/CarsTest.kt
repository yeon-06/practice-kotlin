package domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldNotBeEmpty

class CarsTest : ShouldSpec({

    context("자동차 목록 생성 시") {
        context("중복 이름이 존재한다면") {
            should("오류가 발생한다") {
                shouldThrow<IllegalArgumentException> { Cars(listOf("a", "a")) }
            }
        }

        should("자동차 목록이 생성된다") {
            shouldNotThrow<Exception> { Cars(listOf("a")) }
        }
    }

    context("가장 멀리 있는 위치의 자동차를 찾을 때") {
        val cars = Cars(listOf("a", "b", "c"))

        context("같은 위치에 있는 차가 여러대 있으면") {
            should("해당 차를 모두 반환한다") {
                cars.findMaxLocationCars()
                        .shouldNotBeEmpty()
                        .shouldContainAll(cars.value)
            }
        }

        should("해당 차를 반환한다") {
            val winner = cars.value[0]
            winner.move()

            cars.findMaxLocationCars()
                    .shouldNotBeEmpty()
                    .shouldContainExactly(winner)
        }
    }
})
