package soto.gamma.thecheezery.model

data class Combo(
    val id: Int,
    val name: String,
    val price: Double,
    val products: List<Product>
)
