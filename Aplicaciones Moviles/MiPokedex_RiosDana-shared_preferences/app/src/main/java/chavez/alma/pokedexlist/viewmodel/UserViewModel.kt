package com.tu_paquete.pokedexlist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import chavez.alma.pokedexlist.model.data.bulbasaur
import chavez.alma.pokedexlist.model.domain.Pokemon
import com.tu_paquete.pokedexlist.model.data.User
import com.tu_paquete.pokedexlist.model.data.Users

class UserViewModel(val users: Users) : ViewModel() {

    var currentUser by mutableStateOf<User?>(null)
        private set

    var loginError by mutableStateOf(false)
        private set

    var errorDescription by mutableStateOf("")
        private set

    var companion by mutableStateOf<Pokemon>(bulbasaur)

    init {
        currentUser = users.getCurrentUser()
    }

    fun login(email: String, pass: String): Boolean {
        val user = users.loginService(email, pass)
        return if (user != null) {
            users.saveUser(user.email, user.name)
            currentUser = user
            loginError = false
            errorDescription = ""
            true
        } else {
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos"
            false
        }
    }

    fun isLoggedIn(): Boolean {
        return users.isLoggedIn()
    }

    fun logout() {
        users.logout()
        currentUser = null
    }
}