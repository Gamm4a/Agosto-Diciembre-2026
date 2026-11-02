package soto.gamma.examencompose.Data

data class Usuario(
    val username: String,
    val nombreReal: String,
    val biografia: String,
    val numeroSeguidos: Int,
    val verificado: Boolean,
    val numeroSeguidores: Int,
    val numeroPosts: Int,
    val imagenPerfil: Int
)