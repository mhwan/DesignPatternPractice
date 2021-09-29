package DecoratorPattern

private abstract class Beverage{
    abstract val description: String
    abstract fun cost(): Double
}

private class HouseBlend : Beverage() {
    override val description: String
        get() = "house blend"

    override fun cost(): Double = 3.5
}

private class Espresso : Beverage() {
    override val description: String
        get() = "espresso"

    override fun cost(): Double = 3.5
}

private class Latte: Beverage() {
    override val description: String
        get() = "latte"
    override fun cost(): Double = 3.5
}

/**
 * 여기에 만약 각 커피마다 휘핑 크림을 추가하거나 초콜릿을 추가한다면?
 * 아래처럼 클래스 갯수가 폭발적으로 늘어날 수 밖에 없다.
 */
private class HouseBlendWithSteamedMilkAndMocha: Beverage() {
    override val description: String
        get() = "house blend, steamed milk, mocha"
    override fun cost(): Double = 3.5
}
