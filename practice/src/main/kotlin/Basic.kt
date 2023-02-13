fun main(args: Array<String>) {
    /* val vs var
    val: 변경 불가능한 참조 (java - final)
    var: 변경 가능한 참조
     */
    val num1 = 1
    var num2 = 100
    println(max(num1, num2))

    /* val은 final 같은 존재이다.
    값을 초기화한 뒤 내부 값을 변경하는게 가능하다.
     */
    val person = Person("yeonlog")
    println(person.name)
    person.name = "logyeon"
    println(person.name)

    // enum 예제
    var color = Color.RED;
    println(color.mix(Color.YELLOW))
}

/* if는 문이 아니라 식이다.
식: 값을 만들어 내며 다른 식의 하의 요소로 계산에 참여.
문: 자신을 둘러싸는 가장 안쪽 블록의 최상위 요소로 존재. 값을 만들어내지 않음.
 */
fun max(x: Int, y: Int): Int = if (x > y) x else y

/* 코틀린의 클래스
- 값을 저장하기 위한 비공개 필드, 필드의 게터세터로 이루어진 디폴트 접근자 구현
 */
class Person(
    var name: String
)

// 코틀린의 enum
enum class Color {
    RED, YELLOW, WHITE, BLACK, GREEN, BLUE, ORANGE;

    fun mix(color: Color) =
        when (setOf(color, this)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(BLUE, YELLOW) -> GREEN
            else -> BLACK
        }
}
