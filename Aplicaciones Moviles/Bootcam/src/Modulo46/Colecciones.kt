package Modulo46

fun main() {
    val allBooks = setOf("Hamlet", "Othello", "Macbeth", "King Lear")

    val library = mapOf("William Shakespeare" to allBooks)

    val hasHamlet = library.any { it.value.contains("Hamlet") }
    println("¿La biblioteca tiene Hamlet? $hasHamlet")

    val moreBooks = mutableMapOf("Miguel de Cervantes" to "Don Quijote")

    val title = "La Galatea"
    val result = moreBooks.getOrPut("Miguel de Cervantes") { title }
    println("Libro encontrado o añadido: $result")
}
