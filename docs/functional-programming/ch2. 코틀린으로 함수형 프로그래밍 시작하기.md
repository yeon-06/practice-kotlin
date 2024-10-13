### 프로퍼티 선언
- val: 불변 (읽기 전용)
- var: 가변

### null 처리

- 기본적으로 null safety
- null을 허용하려면 ?를 붙여야 함

### 함수 선언
- fun: 함수 예약어
- = 사용 시 타입 추론이 가능하여 반환 타입 선언 생략 가능

```kotlin
fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b
```

### void & Unit
- java의 void는 Kotlin의 Unit으로 대체
  - void: 원시형 타입; primitive type
  - Unit: 참조형 타입; object type

```kotlin
public object Unit { // object는 싱글턴 객체를 의미
    public override fun toString() = "kotlin.Unit"
}
```

### 익명함수와 람다 표현식
- 익명 함수: 함수 이름을 선언하지 않고, 구현부만 작성하는 함수를 표현하는 방식의 일종
- 코틀린에서 익명 함수를 람다식을 통해 간단히 표현 가능

```kotlin
fun sum(a: Int, b: Int, calculate: (Int, Int) -> Int): Int {
    return calculate(a, b)
}

val result = sum(10, 20, {a, b -> a + b})
```

### 확장 함수; extension function
- 상속이나 내부를 수정하지 않고도 이미 작성되 ㄴ클래스에 함수/프로퍼티 추가 가능
- 별도의 인자를 받지 않고도 this 사용하여 자기 자신의 값에 접근 가능

```kotlin
fun Int.addTen(): Int {
    return this + 10
}
```

### 표현식
- : 구문과 달리 결과로서 어떤 값을 반환
- Kotlin에서는 if, when문이 표현식으로 사용됨
  - 결과값이 프로퍼티에 할당되어야 하므로 반드시 else 작성이 필요

### 코틀린의 인터페이스
- 다중 상속 가능
- 추상 함수 가질 수 있음
- 함수의 본문 구현 가능
- 여러 인터페이스에서 같은 이름의 함수를 가질 수 있음
- 추상 프로퍼티를 가질 수 있음
  - 추상 프로퍼티: 해당 인터페이스를 상속한 클래스가 가질 프로퍼티
  - 인터페이스에서 직접 값을 초기화할 수는 없고, 게터를 구현해야 함

### 클래스
- data class: getter, setter, equals, hashCode, toString, copy 등을 자동으로 생성해주는 클래스
- enum class
- sealed class: enum 클래스의 확장 형태로, 클래스를 묶은 클래스
  - 각 하위 클래스는 모두 다른 프로퍼티와 함수를 가질 수 있음
  - 각 하위 클래스는 sealed class와 동일한 파일에서만 선언 가능

### 비교
- ===: 참조 비교
- ==: 값 비교
- is: 타입 비교

TODO 38p ~
