package Modulo46

// Clase sellada Spice
sealed class Spice(val name: String, val spiciness: String = "mild") : SpiceColor {
    abstract fun prepareSpice()
}

// Subclase Curry
class Curry(spiciness: String,
            color: SpiceColor = YellowSpiceColor
) : Spice("curry", spiciness), Grinder, SpiceColor by color {

    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
        println("El curry se muele en polvo.")
    }
}

fun main() {
    val curry = Curry("hot")
    println("Color del curry: ${curry.color}")
    curry.prepareSpice()
}


