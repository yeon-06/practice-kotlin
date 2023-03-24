package game.console.util

import java.util.*

object RandomUtil {

    private val random = Random()

    fun generateRandom(): Boolean = random.nextBoolean()
}
