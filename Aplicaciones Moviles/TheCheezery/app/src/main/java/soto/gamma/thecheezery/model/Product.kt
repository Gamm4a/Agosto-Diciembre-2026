package soto.gamma.thecheezery.model

data class Product(
    val name: String,
    val price: Double,
    val imageRes: Int,
    val category: ProductCategory
)