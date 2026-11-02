package chavez.alma.pokedexlist.model.data

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import chavez.alma.pokedexlist.model.domain.User
import chavez.alma.pokedexlist.model.preferences.ARCHIVO
import chavez.alma.pokedexlist.model.preferences.USER
import chavez.alma.pokedexlist.model.preferences.USERNAME

class UserViewModel(users: Users) : ViewModel() {
    var currentUser by mutableStateOf<User?>(null)
    init {
        currentUser = users.getCurrentUser()
    }
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")
    val users= users




    fun login(user: String, password: String) {
        val user = users.loginServices(user, password)
        if (user == null) {
            loginError = true
            errorDescription = "Usuario o contrasña incorrectos"

        } else {
            loginError = false
            errorDescription = ""
            users.saveUser(user.email, user.name)
        }


    }

    fun isLoggedIn(): Boolean{
        return users.isLoggein()
    }



}