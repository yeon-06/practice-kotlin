# 코틀린과 함수
> 코틀린의 함수들은 함수를 인자로 받거나 반환값으로 반환하는 것이 가능하다. 코틀린에서 함수는 일급 함수이기 때문이다.

### 고차 함수

- 다음 조건 중 하나 이상을 만족하는 함수
  - 함수를 매개변수로 받는 함수
  - 함수를 반환하는 함수

특징
- 코드의 재사용성을 높인다
- 기능의 확장이 쉽다
- 코드를 간결하게 작성할 수 있다

```kotlin
val result = listOf(1, 2, 3, 4, 5)
    .map { it * 2 }
    .filter { it > 5 } // map, filter 가 함수를 인자로 받는 고차 함수
```

### 부분 함수

- : 모든 가능한 입력 중, 일부 입력에 대한 결과만 정의한 함수
- 함수형 프로그래밍에서는 가급적 모든 입력에 대한 결과를 정의하는 함수가 좋다
- 특정 입력에 대해 예외를 만들면 프로그램의 동작을 예측하기 어렵고, 컴파일된 코드가 실제로 동작하지 않을 가능성이 있기 때문

```kotlin
fun sayNumber(n: Int) = when(n) {
    1 -> "One"
    2 -> "Two"
    3 -> "Three"
    else -> throw IllegalArgumentException("Invalid number") // 1, 2, 3이 아닌 경우에는 결과가 정의되지 않았다
}
```

### 부분 적용 함수

- 매개변수의 일부만 전달받았을 때, 제공받은 매개변수만 가지고 부분 적용 함수를 생성
- TODO 101p

### 커링 함수
- : 여러 개의 매개변수를 받는 함수를 분리하여, 단일 매개변수를 받는 부분 적용 함수의 체인으로 만드는 방법
- 부분 적용 함수를 다양하게 재사용 가능
- 마지막 매개변수가 입력될 때까지 함수 실행을 늦출 수 있음

### 합성 함수
- :함수를 매개변수로 받고, 함수를 반환할 수 있는 고차 함수를 이용해 두 개의 함수를 결합하는 것
- point free style 프로그래밍: 함수 합성을 사용해 매개변수/타입 선언 없이 함수를 만드는 방식

```kotlin
// point free style programming
val minimum = { i: List<Int> -> i.min() }
val negative = { i: List<Int> -> i.map { -it } }
val absolute = { i: List<Int> -> i.map { abs(it) } }

val composed = minimum compose negative compose absolute
val result = composed(listOf(1, 2, 3, 4, 5))
```
