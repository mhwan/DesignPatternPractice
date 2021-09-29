package StrategyPattern

/*
인터페이스로 분리해 기능적으로는 동작할 수 있음
하지만, 코드 간의 재사용 불가능
-> 날아가는 동작을 바꾸기 위해 관련된 클래스의 코드를 모두 고쳐야함
 */
interface Flyable {
    fun fly()
}

interface Quackable {
    fun quack()
}

abstract class Duck2 {
    abstract fun swim()
    abstract fun display()
}

class MallardDuck2: Duck2(), Flyable, Quackable{
    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun quack() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun display() {
        TODO("Not yet implemented")
    }
}

class RubberDuck: Duck2(), Quackable {
    override fun quack() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun display() {
        TODO("Not yet implemented")
    }
}

class FakeDuck2: Duck2() {
    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun display() {
        TODO("Not yet implemented")
    }

}