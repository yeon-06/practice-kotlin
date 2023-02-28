package util

import java.util.Random

object RandomUtil {

    private val random = Random()

    fun generateRandom():Int{
        return random.nextInt(10)
    }
}
