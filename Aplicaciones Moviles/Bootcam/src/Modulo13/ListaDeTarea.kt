package Modulo13

fun main() {
    val trout = "trucha"
    val haddock = "merluza"
    val snapper = "pargo"

    println("¿Me gusta comer $trout? Sí")
    println("¿Me gusta comer $haddock? No")
    println("¿Me gusta comer $snapper? Sí")
}

fun whenExample() {
    val fishName = "Tilapia"

    when (fishName.length) {
        0 -> println("Error: nombre vacío")
        in 3..12 -> println("Buen nombre de pez")
        else -> println("OK nombre de pez")
    }
}
