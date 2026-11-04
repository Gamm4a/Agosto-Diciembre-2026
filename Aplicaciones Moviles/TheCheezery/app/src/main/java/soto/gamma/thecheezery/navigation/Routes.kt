package soto.gamma.thecheezery.navigation

import kotlinx.serialization.Serializable

@Serializable
object Welcome

@Serializable
object Login

@Serializable
object Menu

@Serializable
object Cart

@Serializable
data class Products(
    val category: String
)