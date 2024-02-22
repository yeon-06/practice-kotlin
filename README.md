# 코틀린 연습용 레포지토리

### 폴더 설명

- [practice](./practice)
    - 참고 도서: Kotlin IN ACTION
    - 기본적인 코틀린 문법 익히기
- [racingcar](./racingcar)
    - 원본 레포: https://github.com/woowacourse/kotlin-racingcar
    - 자동차 경주 게임 코틀린으로 만들어보기
- [ladder](./ladder)
    - 사다리 타기 게임 코틀린으로 만들어보기

### 코틀린 상식

#### 코틀린은 기본적으로 null을 허용하지 않는다.
```kotlin
// null을 허용하고 싶다면 ?을 사용하자.
fun length(str: String?) = s.length
```

#### val은 불변이다.
```kotlin
val a = 1
a = 2 // 에러

var b = 1
b = 2 // 정상
```

#### 문자열 템플릿은 $를 사용한다.
```kotlin
val name = "연로그"
println("내 이름은 $name 입니다.") // 내 이름은 연로그 입니다.
println("내 이름은 \\$name 입니다.") // 내 이름은 $name 입니다.
```
