# 자바 개발자를 위한 코틀린 입문

> 목적: [inflearn - '자바 개발자를 위한 코틀린 입문' 강의](https://inf.run/r9oU)를 듣고 내용을 정리하거나 실습을 진행한다.

목차

- [코틀린 공부 꿀팁](#코틀린-공부-꿀팁)
    - [Kotlin 코드를 Java 코드로 디컴파일하기](#Kotlin-코드를-Java-코드로-디컴파일하기)
- [내용 정리](#내용-정리)
    - [section1. 코틀린에서 변수와 타입, 연산자를 다루는 방법](#section1-코틀린에서-변수와-타입-연산자를-다루는-방법)
    - [section2. 코틀린에서 코드를 제어하는 방법](#section2-코틀린에서-코드를-제어하는-방법)
    - [section3. 코틀린에서의 OOP](#section3-코틀린에서의-OOP)
    - [section4. 코틀린에서의 FP](#section4-코틀린에서의-FP)

# 코틀린 공부 꿀팁

## Kotlin 코드를 Java 코드로 디컴파일하기

1. Tools > Kotlin > Show Kotlin Bytecode
   ![img](../images/코틀린%20디컴파일1.png)
2. Decompile 버튼 클릭
   ![img](../images/코틀린%20디컴파일2.png)
3. kotlin 코드와 java 코드 비교
   ![img](../images/코틀린%20디컴파일3.png)

# 내용 정리

## section1. 코틀린에서 변수와 타입, 연산자를 다루는 방법

### 변수 선언

java

```
final int a = 10;   // 불변
var a = 10;         // 가변
int a = 10;         // 가변
```

kotlin

```
val a = 10          // 불변
var a = 10          // 가변
```

### primitive type

java

```
Long number1 = null; // 가능
long number2 = null; // 불가능
```

kotlin

```
var number: Long = 1L   // long이 없고 Long만 있다?!
number = null           // 에러 발생!
```

- boxing/unboxing 신경쓰지 않고 사용할 수 있게 한다
- 다만, null 값은 넣을 수 없다.

### 변수에 null 저장하기

java

```
public int length(String str) {
   return str != null ? str.length() : 0;
}
```

kotlin

- null을 허용하고 싶다면 ?을 사용하자.
- safe call/elvis operator를 이용해 null 체크를 단순화할 수 있다.
    - [코틀린 공식문서 참고](https://kotlinlang.org/docs/null-safety.html)
    - safe call operator `?.`
    - elvis operator `?:`
- null이 절대 아닐때 `!!`를 사용할 수 있다.

```
// Kotlin에서 null 체크하는 예제
fun length(str: String?) = if (str == null) 0 else str.length
fun length(str: String?) = str?.length ?: 0 // null 체크에 대해 더 간단하게 표현할 수도 있다

// null이 절대 아님!!
fun length(str: String?) = str!!.length
```

### 타입 추론

- 코틀린에서는 선언된 기본값을 보고 타입을 추론한다.

```
val a = 1   // int
val b = 1L  // long
```

### 타입 변환

- 기본 타입간의 변환은 **명시적으로** 이루어져야 한다.

java

```
// 암시적으로 변경
int number1 = 1;
long number2 = number1; // 문제없음
```

kotlin

```
// 명시적으로 변경
val number1 = 4
val number2: Long = number1.toLong()
val number3: Long = number1 // 컴파일 에러
```

### 타입 캐스팅

> [예제 코드](./src/main/kotlin/TypeExample.kt)

- java `instanceof` == kotlin `is`
- `as`를 통해 캐스팅 가능
    - value as Type
        - value가 Type -> Type으로 캐스팅
        - value가 Type 아니라면 -> 예외 발생
    - value as? Type
        - value가 Type -> Type으로 캐스팅
        - value가 Type 아니라면 -> null 반환
        - value가 null -> null 반환

### Kotlin에만 있는 type

- Kotlin `Any` == Java `Object`
- Kotlin `Unit` == Java `void`
    - void와 다르게 Unit은 타입 인자로 사용 가능하다. (void는 Void 사용 필요)
    - Unit 의미: 함수형 프로그래밍에서 단 하나의 인스턴스만 갖는 타입. 코틀린에서는 실제 존재하는 타입이라는 것을 표현
- Kotlin `Nothing`
    - 함수가 정상적으로 끝나지 않았다고 표현

### 비교 연산자

- Kotlin에서는 객체를 비교할 때 compareTo를 이용한다.
- 동일성 비교 (객체의 주소 비교)
    - Java `==` == Kotlin `===`
- 동등성 비교 (객체의 값 비교)
    - Java `equals` == Kotlin `==`

### Kotlin에서만 사용하는 연산자

- `in`: 컬렉션이나 범위에 포함되어있다
- `a..b`: a부터 b까지의 범위 객체 생성
- `a[i]`: a에서 index = i 값

## section2. 코틀린에서 코드를 제어하는 방법

### if-else

- Java: Statement; 프로그램의 문장. 하나의 값으로 도출되지 않음
    - 단, 삼항연산자는 Statement이자 Expression이다.
- Kotlin: Expression; 하나의 값으로 도출되는 문장

```kotlin
// 코틀린의 if else는 Expression이기 때문에 바로 return이 가능
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```

### switch

- Kotlin에서는 when 을 사용

```kotlin
fun whenExample(score: Int) =
    when (score) {
        in 90..100 -> "A"
        in 75..89 -> "B"
        in 60..74 -> "C"
        else -> "F"
    }
```

### Range와 Progression

- 1..5 step 2
    - `..`: IntRange를 생성
    - `step`: 중위 함수
    - 1부터 5까지 2씩 증가하는 IntRange 생성

### Checked Exception

- Java에서는 Checked Exception의 경우 메서드마다 throws를 명시해야 한다
- Kotlin에서는 모두 Checked Exception을 사용한다

### try with resources

- Java에서만 존재
- Kotlin에서는 확장 함수를 이용해 사용 가능

```kotlin
fun readFile() {
    BufferedReader(FileReader("input.txt")).use {
        println(it.readLine())
    }
}
```

### 함수 선언 문법

- 기본 접근제어자
    - Java: package-private
    - Kotlin: publish
- Kotlin은 `=`을 이용해 return 생략이 가능

### default parameter

- Java: 메서드 오버로딩을 통해 기본값 세팅 가능
- Kotlin: default parameter를 이용해 기본값 세팅 가능

java

```
public void sum(int a, int b) {
    return a + b;
}

public void sum(int a) {
    return sum(a, 0);
}
```

kotlin

```kotlin
fun sum(a: Int = 0, b: Int = 0) = a + b
```

### named argument

- 어떤 인자에 값을 넣을 것인지 명시할 수 있다
- 단, Kotlin에서 Java 클래스를 호출할 때는 사용 불가

```kotlin
sum(2, 1)
sum(b = 1, a = 2)
sum(a = 2, b = 1)
```

### 가변인자

- Java: `...`
- Kotlin: `vararg`
    - spread operator (`*`): 배열을 풀어서 전달

```kotlin
fun main() {
    println(sum(1, 2, 3, 4, 5))
    val array = arrayOf(1, 2, 3, 4, 5)
    println(sum(*array)) // spread operator
}
fun sum(vararg numbers: Int) = numbers.sum()
```

## section3. 코틀린에서의 OOP

### 클래스

- 생성자 선언 가능
- getter, setter 자동 생성 (사용 시 `Person.age` 식으로 `.`을 통해 접근) -> 때문에 해당 필드를 `프로퍼티`라고 부름
- init (초기화 블록)을 이용해 생성 시 로직 호출 가능 (ex: 값 세팅, 검증 로직)
- 부생성자는 constructor 키워드를 이용해 선언 가능
    - 코틀린에서는 부생성자보다는 default parameter 사용을 권장

```kotlin
class Person(
    val name: String,
    var age: Int
) {

    init { // 초기화 블록
        println("init block")
    }

    // 부생성자
    constructor(name: String) : this(name, 0)

    // 정적 팩토리 메서드
    companion object {
        fun create() = Person("James", 33)
    }
}
```

### extends_example

- extends, implements 대신 `:` 사용
- `@Override` 대신 `override` 사용
- [상속 예제 코드](./src/main/kotlin/extends_example)

### 접근 제어; visibility modifier

- 자바와 코틀린의 가시성 제어
    - 코틀린은 패키지를 namespace 를 관리하는 용도로 쓰고, 가시성 제어할 때 사용하지 않는다

| -         | Java                  | Kotlin                             |
|-----------|-----------------------|------------------------------------|
| public    | 모든 곳에서 접근 가능          | 모든 곳에서 접근 가능                       |
| protected | 같은 패키지/하위 클래스에서 접근 가능 | 선언된 클래스/하위 클래스에서 접근 가능             |
| default   | 같은 패키지에서만 접근 가능       | x                                  |
| internal  | x                     | 같은 모듈(한 번에 컴파일 되는 코틀린 코드)에서만 접근 가능 |
| private   | 선언된 클래스에서만 접근 가능      | 선언된 클래스에서만 접근 가능                   |

### companion object

- 코틀린은 `static`이 없다. 대신 `companion object` 키워드를 사용한다.
- static: 정적으로 인스턴스끼리 값을 공유
- companion object: 클래스와 동행하는 유일한 오브젝트

```kotlin
class Person(
    val name: String = DEFAULT_NAME,
) {
    companion object {
        private const val DEFAULT_NAME = "GUEST"
    }
}
```

### 싱글톤

- `object` 키워드를 이용해 싱글톤 객체 생성 가능

```kotlin
object Singleton {
    var num: Int = 0
}
```

### 익명 클래스

- `object` 키워드를 이용해 익명 클래스 생성 가능

```kotlin
val runnable = object : Runnable {
    override fun run() {
        println("Runnable")
    }
}

// 단, 람다로 표현 가능하다
val runnable = Runnable { println("Runnable") }
```

### 다양한 클래스

- data class
    - equals, hashCode, toString 메서드 자동 생성
    - jdk 16부터 추가된 record 와 유사
- enum class
    - Java와 큰 차이 없음
    - [when과 함께 사용하는 예제 코드](./src/main/kotlin/sealed_example/Main.kt)
- sealed class
    - 상속이 가능한 추상클래스를 외부에서는 상속할 수 없게 만든다.
    - 하위 클래스를 봉인(sealed)한다.
    - 런타임 때 클래스 타입이 추가될 수 없음 (컴파일 타임 때 하위 클래스 타입을 모두 기억)
    - [when과 함께 사용하는 예제 코드](./src/main/kotlin/sealed_example/Main.kt)

## section4. 코틀린에서의 FP
