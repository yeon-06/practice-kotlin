import domain.Cars
import domain.MoveStrategy
import view.InputView
import view.OutputView

fun main() {
    val cars = createCars()
    val tryCount = inputTryCount()
    val strategy = MoveStrategy()
    moving(cars, tryCount, strategy)
    showResult(cars)
}

private fun createCars(): Cars {
    return try {
        val carNames = InputView.inputCarNames()
        Cars(carNames)
    } catch (e: Exception) {
        OutputView.printException(e)
        createCars()
    }
}

private fun inputTryCount(): Int {
    return try {
        InputView.inputTryCount()
    } catch (e: Exception) {
        OutputView.printException(e)
        inputTryCount()
    }
}

private fun moving(cars: Cars, tryCount: Int, strategy: MoveStrategy) {
    OutputView.printStartSentence()
    for (i in 1..tryCount) {
        cars.moveAll(strategy)
        OutputView.printStatus(cars)
    }
}

private fun showResult(cars: Cars) {
    val winnerNames = cars.findMaxLocationCars()
            .map { it.name }
    OutputView.printResult(winnerNames)
}
