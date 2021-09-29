package StrategyPattern

/**
 * 실제 행동을 캡슐화함
 * 다른 객체에서 나는 행동, 꽥꽥거리는 행동을 재사용 가능
 *
 * 새로운 행동을 추가할 때도 기존의 Duck클래스를 변경하지 않고 추가 가능
 *
 * 행동을 setter로 함으로써 프로그램 실행중에 객체의 행동을 바꿀 수도 있음.
 */

fun main() {
    val mallard = SolvedMallardDuck().apply {
        flyBehavior = FlyWithWings()
        quackBehavior = Quack()
    }

    val fake = SolvedFakeDuck().apply {
        flyBehavior = FlyNoWay()
        quackBehavior = MuteQuack()
    }

    mallard.performQuack()
    mallard.performFly()

    fake.performFly()
    fake.performQuack()
}

interface FlyBehavior {
    fun fly()
}

interface QuackBehavior {
    fun quack()
}

class FlyWithWings: FlyBehavior {
    override fun fly() {
        print("진짜로 나는 행동")
    }
}

class FlyNoWay: FlyBehavior {
    override fun fly() {
        print("날 수 없음")
    }
}

class Quack: QuackBehavior {
    override fun quack() {
        print("꽥꽥 되는 행동")
    }
}

class MuteQuack: QuackBehavior {
    override fun quack() {
        print("꽥꽥 될 수 없음")
    }
}

abstract class SolvedDuck {
    var flyBehavior: FlyBehavior? = null
    var quackBehavior: QuackBehavior? = null

    abstract fun display()

    fun performQuack() {
        quackBehavior?.quack()
    }
    fun performFly() {
        flyBehavior?.fly()
    }
}

class SolvedMallardDuck: SolvedDuck() {
    override fun display() {
        TODO("Not yet implemented")
    }
}

class SolvedFakeDuck: SolvedDuck() {
    override fun display() {
        TODO("Not yet implemented")
    }

}
