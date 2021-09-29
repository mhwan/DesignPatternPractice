package FactoryPattern.FactoryMethodPattern

fun main() {
    val nyStore = NYPizzaStore()
    val chicagoStore = ChicagoPizzaStore()

    nyStore.orderPizza(Type.CHEESE)
    chicagoStore.orderPizza(Type.PEPPERONI)
}

enum class Type { CHEESE, PEPPERONI, VEGGIE }

abstract class PizzaStore {
    abstract fun createPizza(type: Type): Pizza

    fun orderPizza(type: Type): Pizza = createPizza(type).apply {
        prepare()
        bake()
        cut()
        box()
    }
}

class NYPizzaStore: PizzaStore() {
    override fun createPizza(type: Type) = when(type) {
        Type.CHEESE -> NYStyleCheesePizza()
        Type.PEPPERONI -> NYStylePepperoniPizza()
        Type.VEGGIE -> NYStyleVeggiePizza()
    }
}

class ChicagoPizzaStore: PizzaStore() {
    override fun createPizza(type: Type) = when(type) {
        Type.CHEESE -> ChicagoStyleCheesePizza()
        Type.PEPPERONI -> ChicagoStylePepperoniPizza()
        Type.VEGGIE -> ChicagoStyleVeggiePizza()
    }
}

abstract class Pizza {
    abstract val name: String
    abstract val dough: String
    abstract val sauce: String

    fun prepare() {
        println("prepare : $name")
        println("Tossing dough...")
        println("adding sauce...")
    }

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

class NYStyleCheesePizza: Pizza() {
    override val name: String
        get() = "NY style sauce, cheese pizza"
    override val dough: String
        get() = "thin crust dough"
    override val sauce: String
        get() = "marinara sauce"
}

class NYStylePepperoniPizza: Pizza() {
    override val name: String
        get() = "NY style sauce, pepperoni pizza"
    override val dough: String
        get() = "thin crust dough"
    override val sauce: String
        get() = "tomato sauce"
}

class NYStyleVeggiePizza: Pizza() {
    override val name: String
        get() = "NY style sauce, veggie pizza"
    override val dough: String
        get() = "thin crust dough"
    override val sauce: String
        get() = "marinara sauce"
}

class ChicagoStyleCheesePizza: Pizza() {
    override val name: String
        get() = "Chicago style sauce, cheese pizza"
    override val dough: String
        get() = "crust dough"
    override val sauce: String
        get() = "marinara sauce"
}

class ChicagoStylePepperoniPizza: Pizza() {
    override val name: String
        get() = "Chicago style sauce, pepperoni pizza"
    override val dough: String
        get() = "crust dough"
    override val sauce: String
        get() = "tomato sauce"
}

class ChicagoStyleVeggiePizza: Pizza() {
    override val name: String
        get() = "Chicago style sauce, veggie pizza"
    override val dough: String
        get() = "crust dough"
    override val sauce: String
        get() = "marinara sauce"
}