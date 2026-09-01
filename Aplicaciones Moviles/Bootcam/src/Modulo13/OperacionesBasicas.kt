package Modulo13

import kotlin.math.ceil

//peses y acuarios
fun peces() {
    println((2.plus(71).plus(233).minus(13)).let {
        "Peces: $it, Acuarios: ${ceil(it / 30.0).toInt()}"
    })
}
//variables de Modulo13.colores
fun colores() {
    var rainbowColor = "Rojo"
    rainbowColor = "Verde"

    val blackColor = "Negro"
    // blackColor = "Blanco"
}

//Modulo13.nulas
fun nulas() {
    var rainbowColor: String? = null
    var greenColor: String? = null
    var blueColor = null as String?
}

//Modulo13.nulos
fun nulos() {
    val lista1 = listOf<String?>(null, null)
    val lista2 = listOf(null, null)

    val listaNula: List<String>? = null
}

//Evis
fun elvis() {
    val nullTest: Int? = null
    val resultado = (nullTest?.plus(1)) ?: 0
    println(resultado)
}









