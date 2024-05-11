package sealed_example

sealed class Juice(
    val fruit: String,
)

class OrangeJuice : Juice("🍊")
class AppleJuice : Juice("🍎")
class GrapeJuice : Juice("🍇")
