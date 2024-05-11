package sealed_example

fun main() {
    cutFruit(Fruit.ORANGE)
    cutFruit(Fruit.APPLE)
    cutFruit(Fruit.GRAPE)

    makeJuice(OrangeJuice())
    makeJuice(AppleJuice())
    makeJuice(GrapeJuice())
}

fun cutFruit(fruit: Fruit) {
    when (fruit) {
        Fruit.ORANGE -> println("오렌지를 손으로 깝니다.")
        Fruit.APPLE -> println("사과를 칼로 깎습니다.")
        Fruit.GRAPE -> println("포도는 꼭지를 따냅니다.")
    }
}

fun makeJuice(juice: Juice) {
    when (juice) {
        is OrangeJuice -> println("새콤한 ${juice.fruit} 주스를 만듭니다.")
        is AppleJuice -> println("달콤한 ${juice.fruit} 주스를 만듭니다.")
        is GrapeJuice -> println("알딸딸한 ${juice.fruit} 주스를 만듭니다.")
    }
}

