package Modulo13

import java.util.Calendar

//crea una funcion y la llamas
fun main() {
    dayOfWeek()
}

fun dayOfWeek() {
    println("¿Qué día es hoy?")
}

//-----

//uso del calendar y del when

fun main2() {
    dayOfWeek2()
}

fun dayOfWeek2() {
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    when (day) {
        Calendar.SUNDAY -> println("Hoy es Domingo")
        Calendar.MONDAY -> println("Hoy es Lunes")
        Calendar.TUESDAY -> println("Hoy es Martes")
        Calendar.WEDNESDAY -> println("Hoy es Miércoles")
        Calendar.THURSDAY -> println("Hoy es Jueves")
        Calendar.FRIDAY -> println("Hoy es Viernes")
        Calendar.SATURDAY -> println("Hoy es Sábado")
    }
}
