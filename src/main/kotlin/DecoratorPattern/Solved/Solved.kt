package DecoratorPattern.Solved

/**
 * 데코레이터 패턴 : 객체에 추가적인 요소를 동적으로 첨가함
 * 구성요소를 위한 component클래스가 있고, 이를 구현하는 ConcreteComponent 클래스가 있음.
 * Decorator : 여기에 장식할 수 있는 구성요소같은 인터페이스나 추상 클래스를 구현
 * 실제 데코레이터는 ConcreteDecoratorA같이 데코레이터 클래스를 상속받아 구현함
 *
 * 서브 클래스를 만드는 것보다 유연하게 기능을 확장할 수 있는 장점이 있다.
 */

/**
 * 데코레이터 패턴의 단점
 * 여러개의 데코레이터가 생길때마다 자잘한 크기의 클래스가 매우 많이 생기게 되고,
 * 다른 사람이 봤을때 이해하기 힘든 아키텍쳐 디자인이 되기도함
 *
 * 클라이언트쪽에서 데코레이터를 끼워넣어도 데코레이터를 사용하는 것을 모르는게 이 패턴의 장점인데,
 * 클라이언트 코드가 특정 형식에 의존하도록 짜서 적용하면 문제가 됨.
 *
 * 객체를 초기화하는데 필요한 초기 코드가 복잡해지는 단점
 */

fun main() {
    val beverage = Espresso()
    println("${beverage.description} : ${beverage.cost()}")

    var beverage2: Beverage = DarkRoast()
    beverage2 = Mocha(beverage2)
    beverage2 = Mocha(beverage2)
    beverage2 = Whip(beverage2)
    println("${beverage2.description} : ${beverage2.cost()}")

    var beverage3: Beverage = HouseBlend()
    beverage3 = Soy(beverage3)
    beverage3 = Mocha(beverage3)
    beverage3 = Whip(beverage3)
    println("${beverage3.description} : ${beverage3.cost()}")
}

/**
 * beverage (component class)
 * HouseBlend, Espresso, DarkRoast (ConcreteComponent class)
 */
private abstract class Beverage{
    abstract val description: String
    abstract fun cost(): Double
}

private class HouseBlend: Beverage() {
    override val description: String
        get() = "house blend"

    override fun cost(): Double = 3.5
}

private class DarkRoast: Beverage() {
    override val description: String
        get() = "dark roast"

    override fun cost(): Double = 3.8
}

private class Espresso: Beverage() {
    override val description: String
        get() = "espresso"

    override fun cost(): Double = 3.2
}

/**
 * CondimentDecorator : Decorator class
 * Mocha, Whip, Soy : ConcreteCondimentDecorator class
 */
private abstract class CondimentDecorator: Beverage() {
    abstract val beverage: Beverage
}

private class Mocha(override val beverage: Beverage) : CondimentDecorator() {
    override val description: String
        get() = beverage.description + ", mocha"

    override fun cost(): Double = 0.2 + beverage.cost()
}

private class Whip(override val beverage: Beverage) : CondimentDecorator() {
    override val description: String
        get() = beverage.description + ", whip"

    override fun cost(): Double = 0.3 + beverage.cost()
}

private class Soy(override val beverage: Beverage) : CondimentDecorator() {
    override val description: String
        get() = beverage.description + ", soy"

    override fun cost(): Double = 0.4 + beverage.cost()
}

