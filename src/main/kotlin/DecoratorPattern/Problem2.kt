package DecoratorPattern

private abstract class Beverage2{
    abstract val description: String
    abstract fun cost(): Double
    abstract var milk: Boolean
    abstract var soy: Boolean
    abstract var mocha: Boolean
    abstract var whip: Boolean
}

/**
 * Beverage클래스에 음료에 추가적으로 첨가될 수 있는걸 만들고
 * 이를 상속하는 클래스에서 넣고 빼고를 결정하는 방식
 */
private class ProblemHouseBlend: Beverage2() {
    override val description: String
        get() = "house blend"

    override fun cost(): Double {
        TODO("Not yet implemented")
    }

    override var milk: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}
    override var soy: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}
    override var mocha: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}
    override var whip: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}

}

/**
 * 이렇게 하면 각 음료 클래스 밖에 안만들어지기는 하지만.
 * 첨가물의 가격이 바뀔때마다 기존 코드를 수정해야함
 * 첨가물 종류가 생기면 새로운 메소드를 추가하고 기존 메소드를 고쳐야함
 *
 * Tea같이 특정 첨가물이 들어가면 안되는 경우에도 여전히 상속을 받게 되는 문제 발생
 *
 * -> OCP원칙을 위해 기존의 코드를 수정하지 않고 새로 확장하게 하기위해 데코레이터 패턴 사용
 */