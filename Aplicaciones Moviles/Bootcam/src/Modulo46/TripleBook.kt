package Modulo46

class Book(val title: String, val author: String, val year: Int) {

    fun getTitleAuthor(): Pair<String, String> {
        return Pair(title, author)
    }

    fun getBookInfo(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

fun main() {

    val book = Book("Clean Code", "Robert C. Martin", 2008)

    val (title, author) = book.getTitleAuthor()
    println("Título: $title, Autor: $author")

    val (t, a, y) = book.getBookInfo()
    println("Título: $t, Autor: $a, Año: $y")

    println("Aquí está tu libro $t escrito por $a en $y")
}
