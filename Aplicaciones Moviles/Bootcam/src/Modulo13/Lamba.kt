package Modulo13


//Lambda
fun main() {
    val rollDice = { (1..12).random() }
    println("Tirada de 12 caras: ${rollDice()}")
    val rollDiceWithSides = { sides: Int ->
        if (sides == 0) 0 else (1..sides).random()
    }
    println("Tirada de 6 caras: ${rollDiceWithSides(6)}")
    val rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0 else (1..sides).random()
    }
    println("Tirada con rollDice2 (20 caras): ${rollDice2(20)}")
}

//type notation
fun gamePlay(roll: Int) {
    println("El resultado del dado es: $roll")
}

fun main() {
    val rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0 else (1..sides).random()
    }

    // 2. Pasar la función como argumento
    gamePlay(rollDice2(12))
    gamePlay(rollDice2(6))
}

