package domain

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldNotBeEmpty

class CarsTest : ShouldSpec({

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
