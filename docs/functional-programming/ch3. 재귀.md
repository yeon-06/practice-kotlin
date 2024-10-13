# 재귀

> 함수형 프로그래밍에서는 명령문을 반복할 때 루프 대신 재귀 사용

- 어떤 함수의 구현 내부에서 자기 자신을 호출하는 함수를 정의하는 방법
- 어떻게(how)가 아닌 무엇을(what)을 선언할지 고민해야 함

### 설계 방법

- 종료 조건(edge condition)이 적어도 1개 이상 존재
- 재귀를 반복할수록 종료조건으로 수렴

### 메모제이션

- : 어떤 반복된 연산을 수행할 때 이전에 계산했던 값을 캐싱해서 중복된 연산을 제거하는 방법
- 재귀 함수의 성능을 향상시키기 위해 사용

```kotlin
fun fib(n: Int): Int {
    val memo = IntArray(n + 1) { -1 }
    fun go(n: Int): Int {
        if (n <= 1) return n
        if (memo[n] != -1) return memo[n]
        memo[n] = go(n - 1) + go(n - 2)
        return memo[n]
    }
    return go(n)
}
```

- 순수한 함수는 부수효과가 없고, 불변성을 띰 (위 예제에서는 memo 로 인해 부수효과가 발생)
- 순수한 함수에서 메모제이션을 이용하려면 이미 계산된 값을 재귀 함수의 매개변수를 받아 캐싱하면 됨 -> 꼬리 재귀에 대해 알아보자

```kotlin
fun fib(n: Int): Int = fiboFP(n, 0, 1)

// tailrec: 꼬리 재귀 함수라는 의미의 어노테이션
tailrec fun fiboFP(n: Int, a: Int, b: Int): Int = when (n) { 
    0 -> a
    1 -> b
    else -> fiboFP(n - 1, b, a + b)
}
```

### 꼬리 재귀

- : 어떤 함수가 직간접적으로 자기 자신을 호출하면서도 그 호출이 마지막 연산인 경우
