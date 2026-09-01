package Modulo13

fun mainn() {
    println("Tu fortuna es: ${getFortuneCookie()}")
}

fun getFortuneCookie(): String {
    val fortunes = listOf(
        "¡Tenderás un gran día!",
        "Las cosas te irán bien hoy.",
        "Disfruta de un maravilloso día de éxito.",
        "Sé humilde y todo saldrá bien.",
        "Hoy es un buen día para ejercer moderación.",
        "¡Tómatelo con calma y disfruta de la vida!",
        "Atesora a tus amigos porque son tu mayor fortuna."
    )

    print("Introduce tu fecha de nacimiento: ")
    val birthday = readLine()?.toIntOrNull() ?: 1

    val index = birthday % fortunes.size
    return fortunes[index]
}


//-----------

import java.util.*

fun main() {
    var fortune: String
    for (i in 1..10) {
        fortune = getFortune2(getBirthday2())
        println("\nTu fortuna es: $fortune")
        if (fortune.contains("Tómatelo con calma")) break
    }
}

// 1. Función para obtener el cumpleaños
fun getBirthday2(): Int {
    print("Introduce tu fecha de nacimiento: ")
    val birthday = readLine()?.toIntOrNull() ?: 1
    return birthday
}

// 2. Función para obtener la fortuna según el cumpleaños
fun getFortune2(birthday: Int): String {
    val fortunes = listOf(
        "¡Tenderás un gran día!",
        "Las cosas te irán bien hoy.",
        "Disfruta de un maravilloso día de éxito.",
        "Sé humilde y todo saldrá bien.",
        "Hoy es un buen día para ejercer moderación.",
        "¡Tómatelo con calma y disfruta de la vida!",
        "Atesora a tus amigos porque son tu mayor fortuna."
    )

    return when {
        birthday == 28 || birthday == 31 -> "¡Un día especial te espera!"
        birthday in 1..7 -> "La primera semana trae buena suerte."
        else -> fortunes[birthday % fortunes.size]
    }
}

//------- AJUSTAR MÁS PESES


fun canAddFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true
): Boolean {
    val capacity = if (hasDecorations) tankSize * 0.8 else tankSize
    val totalFishLength = currentFish.sum() + fishSize
    return totalFishLength <= capacity
}


//--------- WHATSHOULDDOTODAY

fun main() {
    println(whatShouldIDoToday("happy", "Sunny", 25))
    println(whatShouldIDoToday("sad"))
    println(whatShouldIDoToday("energetic", "Rainy", 10))
    println(whatShouldIDoToday("relaxed", "Cloudy", 18))
}

fun whatShouldIDoToday(
    mood: String,
    weather: String = "Sunny",
    temperature: Int = 24
): String {
    return when {
        mood == "happy" && weather == "Sunny" -> "Go for a walk"
        mood == "energetic" && weather == "Rainy" -> "Go to the gym"
        temperature < 0 -> "Stay inside and keep warm"
        temperature > 30 -> "Go swimming"
        else -> "Stay home and relax"
    }
}

//------- filtros

fun main() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    // 1. Filtrar todos los currys y ordenarlos por longitud
    val curries = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println("Currys ordenados: $curries")

    // 2. Filtrar especias que empiezan con 'c' y terminan con 'e' (dos maneras)
    val cEndE1 = spices.filter { it.startsWith("c") && it.endsWith("e") }
    println("Empiezan con c y terminan con e (forma 1): $cEndE1")

    val cEndE2 = spices.filter { it.matches(Regex("^c.*e$")) }
    println("Empiezan con c y terminan con e (forma 2): $cEndE2")

    // 3. Tomar los tres primeros elementos y devolver los que empiezan con 'c'
    val firstThreeC = spices.take(3).filter { it.startsWith("c") }
    println("Primeros tres que empiezan con c: $firstThreeC")
}
