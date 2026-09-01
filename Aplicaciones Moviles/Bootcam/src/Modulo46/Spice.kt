package Modulo46

open class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            "medium" -> 7
            "hot" -> 10
            else -> 0
        }


    init {
        println("Se creó la especia: $name, nivel: $spiciness, heat: $heat")
    }
}

fun main() {

    val curry = Spice("curry", "mild")


    val spices = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "hot"),
        Spice("ginger", "mild"),
        Spice("red curry", "hot"),
        Spice("green curry", "medium"),
        Spice("red pepper", "hot")
    )


    val spicySpices = spices.filter { it.heat >= 7 }
    println("Especias picantes: ${spicySpices.map { it.name }}")


    val salt = makeSalt()
    println("Especia común: ${salt.name}, heat: ${salt.heat}")
}


fun makeSalt() = Spice("Salt")












