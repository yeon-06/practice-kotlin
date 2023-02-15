interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// 타입캐스트가 필요없는 코틀린
fun eval1(e: Expr): Int {
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return eval1(e.right) + eval1(e.left)
    }
    throw IllegalArgumentException("Unknown Expression")
}

// 리팩터링 - if -> when
fun eval2(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval2(e.right) + eval2(e.left)
            else -> throw IllegalArgumentException("Unknown Expression")
        }

fun main() {
    // 분기문 예제
    val sum = Sum(Num(1), Num(2))
    println(eval2(Sum(sum, Num(4))))

    // 반복문 예제
    for (i in 1..5) {
        println(i)
    }

    // in 예제
    val result = 'a' in '0'..'9'
    println(result)

    // 예외 처리 예제
    val num = try {
        Integer.parseInt("test")
    } catch (e: NumberFormatException) {
        null
    }
    println(num)
}
