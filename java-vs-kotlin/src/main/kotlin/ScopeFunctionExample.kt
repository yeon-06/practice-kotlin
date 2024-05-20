fun main() {
    val person = Person("John", 25)

    val letEx = person.let {
        println("let 호출!")
        it.age  // it 사용
    }
    println("let 응답 결과 --> $letEx") // 25

    val runEx = person.run {
        println("run 호출!")
        age     // this 사용 (생략 가능)
    }
    println("run 응답 결과 --> $runEx") // 25

    val alsoEx = person.also {
        println("also 호출!")
        it.age  // it 사용
    }
    println("also 응답 결과 --> $alsoEx")   // Person(name=John, age=25)

    val applyEx = person.apply {
        println("apply 호출!")
        age     // this 사용 (생략 가능)
    }
    println("apply 응답 결과 --> $applyEx") // Person(name=John, age=25)

    val withEx = with(person) {
        println("with 호출!")
        age
    }
    println("with 응답 결과 --> $withEx") // 25
}

data class Person(var name: String, var age: Int)
