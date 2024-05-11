package extends_example

class Penguin : Animal("펭귄", 2), Swim, Walk {
    private val wingCount: Int = 2

    override fun move() {
        println("꽁꽁 얼어붙은 남극 위로 펭귄이 걸어다닙니다.")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swim>.act()
        super<Walk>.act()
    }
}
