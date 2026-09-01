package Modulo46

class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"

    // Propiedad calculada: heat
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
}

fun main() {
    val spice = SimpleSpice()
    println("Nombre: ${spice.name}, Heat: ${spice.heat}")
}












