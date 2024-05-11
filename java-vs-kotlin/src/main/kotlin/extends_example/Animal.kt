package extends_example

abstract class Animal (
    protected val species: String,
    protected open val legCount: Int, // override 를 위해 open 추가
){

    abstract fun move()
}
