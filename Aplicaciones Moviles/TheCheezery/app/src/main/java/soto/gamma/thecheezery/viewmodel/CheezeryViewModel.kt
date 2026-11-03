package soto.gamma.thecheezery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import soto.gamma.thecheezery.R
import soto.gamma.thecheezery.model.Product
import soto.gamma.thecheezery.model.ProductCategory

class CheezeryViewModel : ViewModel() {

    val products = listOf(

        // HOT DRINKS
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

    var cartProducts by mutableStateOf(listOf<Product>())
        private set

    fun addToCart(product: Product) {
        cartProducts = cartProducts + product
    }

    fun removeFromCart(product: Product) {
        cartProducts = cartProducts - product
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
