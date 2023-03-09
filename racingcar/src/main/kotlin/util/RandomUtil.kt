package util

import java.util.*

object RandomUtil {

    private val random = Random()

    fun generateRandom(): Int = random.nextInt(10)
}
