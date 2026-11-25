package soto.gamma.thecheezery.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import soto.gamma.thecheezery.R
import soto.gamma.thecheezery.model.Combo
import soto.gamma.thecheezery.model.Product
import soto.gamma.thecheezery.model.ProductCategory
import soto.gamma.thecheezery.model.data.database.AppDatabase
import soto.gamma.thecheezery.model.data.database.entity.ProductEntity
import soto.gamma.thecheezery.model.data.repository.CheezeryRepository

class CheezeryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CheezeryRepository

    var products by mutableStateOf(listOf<Product>())
        private set

    var combos by mutableStateOf(listOf<Combo>())
        private set

    private val sampleProducts = listOf(

        // bevidas calientes
        Product(
            "Americano",
            65.0,
            R.drawable.americano,
            ProductCategory.HOT_DRINKS
        ),
        Product(
            "Espresso",
            60.0,
            R.drawable.espresso,
            ProductCategory.HOT_DRINKS
        ),
        Product(
            "Latte",
            75.0,
            R.drawable.latte,
            ProductCategory.HOT_DRINKS
        ),
        Product(
            "Matcha",
            80.0,
            R.drawable.matcha,
            ProductCategory.HOT_DRINKS
        ),
        Product(
            "Chai Latte",
            80.0,
            R.drawable.chailatte,
            ProductCategory.HOT_DRINKS
        ),
        Product(
            "Capuccino",
            75.0,
            R.drawable.capuccino,
            ProductCategory.HOT_DRINKS
        ),
        Product(
            "Hot Chocolate",
            85.0,
            R.drawable.hotchocolate,
            ProductCategory.HOT_DRINKS
        ),

        // COLD DRINKS
        Product(
            "Cold Brew",
            75.0,
            R.drawable.coldbrew,
            ProductCategory.COLD_DRINKS
        ),
        Product(
            "Caramel Frap",
            90.0,
            R.drawable.caramel_frap,
            ProductCategory.COLD_DRINKS
        ),
        Product(
            "Chocolate Frap",
            90.0,
            R.drawable.chocolate_frap,
            ProductCategory.COLD_DRINKS
        ),
        Product(
            "Oreo Milkshake",
            95.0,
            R.drawable.oreomilkshake,
            ProductCategory.COLD_DRINKS
        ),
        Product(
            "Peanut Milkshake",
            95.0,
            R.drawable.peanutmilshake,
            ProductCategory.COLD_DRINKS
        ),

        // SALTIES
        Product(
            "Club Sandwich",
            110.0,
            R.drawable.clubsandwich,
            ProductCategory.SALTIES
        ),
        Product(
            "Panini",
            100.0,
            R.drawable.hampanini,
            ProductCategory.SALTIES
        ),
        Product(
            "Philly Cheesesteak",
            130.0,
            R.drawable.phillycheesesteak,
            ProductCategory.SALTIES
        ),
        Product(
            "Chicken Crepes",
            115.0,
            R.drawable.chickencrepes,
            ProductCategory.SALTIES
        ),
        Product(
            "Nachos",
            90.0,
            R.drawable.nachos,
            ProductCategory.SALTIES
        ),

        // SWEETS
        Product(
            "Blueberry Cake",
            85.0,
            R.drawable.blueberrycake,
            ProductCategory.SWEETS
        ),
        Product(
            "Chocolate Cupcake",
            70.0,
            R.drawable.chocolatecupcake,
            ProductCategory.SWEETS
        ),
        Product(
            "Lemon Tartalette",
            80.0,
            R.drawable.lemontartalette,
            ProductCategory.SWEETS
        ),
        Product(
            "Muffin",
            60.0,
            R.drawable.muffin,
            ProductCategory.SWEETS
        ),
        Product(
            "Red Velvet Cake",
            85.0,
            R.drawable.redvelvetcake,
            ProductCategory.SWEETS
        ),
        Product(
            "Strawberry Cheesecake",
            90.0,
            R.drawable.strawberrycheesecake,
            ProductCategory.SWEETS
        ),
        Product(
            "Tiramisu",
            95.0,
            R.drawable.tiramisu,
            ProductCategory.SWEETS
        )
    )

    init {
        val database = AppDatabase.getInstance(application)
        repository = CheezeryRepository(
            database.productDao(),
            database.comboDao()
        )

        viewModelScope.launch {
            if (repository.getAllProducts().isEmpty()) {
                repository.insertProducts(
                    sampleProducts.map { product ->
                        ProductEntity(
                            name = product.name,
                            price = product.price.toFloat(),
                            imageRes = product.imageRes,
                            category = product.category.name
                        )
                    }
                )
            }
            loadProducts()
            loadCombos()
        }
    }

    var cartProducts by mutableStateOf(listOf<Product>())
        private set

    fun addToCart(product: Product) {
        cartProducts = cartProducts + product
    }

    fun removeFromCart(product: Product) {
        cartProducts = cartProducts - product
    }

    private fun toProduct(entity: ProductEntity): Product =
        Product(
            name = entity.name,
            price = entity.price.toDouble(),
            imageRes = entity.imageRes,
            category = ProductCategory.valueOf(entity.category),
            id = entity.id
        )

    private suspend fun loadProducts() {
        products = repository.getAllProducts().map(::toProduct)
    }

    private suspend fun loadCombos() {
        combos = repository.getAllCombos().map { relation ->
            Combo(
                id = relation.combo.id,
                name = relation.combo.name,
                price = relation.combo.price.toDouble(),
                products = relation.products.map(::toProduct)
            )
        }
    }

    fun createCombo(name: String, price: Double, productIds: List<Int>) {
        viewModelScope.launch {
            repository.insertCombo(name, price.toFloat(), productIds)
            loadCombos()
        }
    }

    fun getProductsByCategory(
        category: ProductCategory
    ): List<Product> {
        return products.filter {
            it.category == category
        }
    }

    fun calculateTotal(): Double {
        return cartProducts.sumOf {
            it.price
        }
    }
}
