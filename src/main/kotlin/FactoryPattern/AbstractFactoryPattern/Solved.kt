package FactoryPattern.AbstractFactoryPattern

enum class PizzaType { CHEESE, PEPPERONI }

fun main() {
    val nyStore = NYPizzaStore()
    val chicagoStore = ChicagoPizzaStore()

    nyStore.orderPizza(PizzaType.CHEESE)
    chicagoStore.orderPizza(PizzaType.PEPPERONI)
}

abstract class PizzaStore {
    abstract fun createPizza(type: PizzaType): Pizza

    fun orderPizza(type: PizzaType): Pizza = createPizza(type).apply {
        prepare()
        bake()
        cut()
        box()
    }
}

class NYPizzaStore: PizzaStore() {
    private val ingredientFactory = NYPizzaIngredientFactory()
    override fun createPizza(type: PizzaType): Pizza = when(type) {
        PizzaType.CHEESE -> CheesePizza("newyork style cheese pizza", ingredientFactory)
        PizzaType.PEPPERONI -> PepperoniPizza("newyork style pepperoni pizza", ingredientFactory)
    }
}

class ChicagoPizzaStore: PizzaStore() {
    private val ingredientFactory = ChicagoPizzaIngredientFactory()
    override fun createPizza(type: PizzaType): Pizza = when(type) {
        PizzaType.CHEESE -> CheesePizza("chicago style cheese pizza", ingredientFactory)
        PizzaType.PEPPERONI -> PepperoniPizza("chicago style pepperoni pizza", ingredientFactory)
    }
}

abstract class Pizza(val name: String, val ingredientFactory: PizzaIngredientFactory) {
    abstract val dough: Dough
    abstract val sauce: Sauce
    abstract fun prepare()
    fun bake() {
        println("bake for 25 minutes at 350")
    }

    fun cut() {
        println("cutting the pizza into diagonal slices")
    }

    fun box() {
        println("place pizza in official pizza store box")
    }
}

private class CheesePizza(name: String, ingredientFactory: PizzaIngredientFactory): Pizza(name, ingredientFactory) {
    override val dough: Dough
        get() = ingredientFactory.createDough()
    override val sauce: Sauce
        get() = ingredientFactory.createSauce()

    override fun prepare() {
        println("prepare : $name")
    }
}

private class PepperoniPizza(name: String, ingredientFactory: PizzaIngredientFactory): Pizza(name, ingredientFactory) {
    override val dough: Dough
        get() = ingredientFactory.createDough()
    override val sauce: Sauce
        get() = ingredientFactory.createSauce()

    override fun prepare() {
        println("prepare : $name")
    }
}
interface PizzaIngredientFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
}

class NYPizzaIngredientFactory: PizzaIngredientFactory{
    override fun createDough(): Dough = ThinCrustDough()

    override fun createSauce(): Sauce = PlumMarinaraSauce()

    override fun createCheese(): Cheese = ReggianoCheese()
}

private class ChicagoPizzaIngredientFactory: PizzaIngredientFactory {
    override fun createDough(): Dough = ThickCrustDough()

    override fun createSauce(): Sauce = PlumTomatoSauce()

    override fun createCheese(): Cheese = MozzarellaCheese()
}

interface Dough
private class ThickCrustDough: Dough
private class ThinCrustDough: Dough

interface Sauce
private class PlumTomatoSauce: Sauce
private class PlumMarinaraSauce: Sauce

interface Cheese
private class MozzarellaCheese: Cheese
private class ReggianoCheese: Cheese