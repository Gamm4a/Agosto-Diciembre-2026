package Modulo46

// Clase abstracta Spice (ya creada antes)
abstract class Spice(val name: String, val spiciness: String = "mild") {
    abstract fun prepareSpice()
}

// Subclase simple para ejemplo
class Curry(spiciness: String) : Spice("curry", spiciness) {
    override fun prepareSpice() {
        println("El curry se muele en polvo.")
    }
}

// 1. Clase de datos SpiceContainer
data class SpiceContainer(val spice: Spice) {
    // 2. Propiedad label derivada del nombre de la especia
    val label: String = spice.name
}
