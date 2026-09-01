package Modulo46

class Book(val title: String, val author: String) {
    private var currentPage: Int = 0

    open fun readPage() {
        currentPage++
        println("Leyendo página $currentPage del libro '$title'")
    }
}

class eBook(title: String, author: String, val format: String = "texto") : Book(title, author) {
    private var wordCount: Int = 0

    override fun readPage() {
        wordCount += 250
        println("Leyendo eBook '$title' en formato $format, palabras leídas: $wordCount")
    }
}

fun main() {
    val libro = Book("El Quijote", "Cervantes")
    libro.readPage()
    libro.readPage()

    val ebook = eBook("Clean Code", "Robert C. Martin")
    ebook.readPage()
    ebook.readPage()
}






