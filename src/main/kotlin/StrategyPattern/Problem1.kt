package StrategyPattern

abstract class Duck {
    abstract fun quack()
    abstract fun swim()
    abstract fun fly()
}

class MallardDuck: Duck(){
    override fun quack() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }
}

//가짜 duck에게 할 수 없는 꽥꽥거리는 것, fly등이 있음.
class FakeDuck: Duck(){
    override fun quack() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }

}