package FactoryPattern

private enum class Style { NY, CHICAGO }
private enum class ProblemType { CHEESE, PEPPERONI, VEGGIE }

private interface ProblemPizza {
    fun prepare()
    fun bake()
    fun cut()
    fun box()
}

private class ProblemNYStyleCheesePizza : ProblemPizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}

private class ProblemNYStylePepperoniPizza : ProblemPizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}
private class ProblemNYStyleVeggiePizza : ProblemPizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}
private class ProblemChicagoStyleCheesePizza : ProblemPizza{
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}
private class ProblemChicagoStylePepperoniPizza : ProblemPizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}
private class ProblemChicagoStyleVeggiePizza : ProblemPizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}

private class DependentPizzaStore {
    fun createPizza(style: Style, type: ProblemType): ProblemPizza = when (style) {
        Style.NY -> {
            when (type) {
                ProblemType.CHEESE -> ProblemNYStyleCheesePizza()
                ProblemType.PEPPERONI -> ProblemNYStylePepperoniPizza()
                ProblemType.VEGGIE -> ProblemNYStyleVeggiePizza()
            }
        }
        Style.CHICAGO -> {
            when (type) {
                ProblemType.CHEESE -> ProblemChicagoStyleCheesePizza()
                ProblemType.PEPPERONI -> ProblemChicagoStylePepperoniPizza()
                ProblemType.VEGGIE -> ProblemChicagoStyleVeggiePizza()
            }
        }
    }.apply {
        prepare()
        bake()
        cut()
        box()
    }

}

