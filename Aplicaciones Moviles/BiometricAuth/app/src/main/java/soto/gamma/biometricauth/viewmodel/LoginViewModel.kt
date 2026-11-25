package soto.gamma.biometricauth.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import soto.gamma.biometricauth.data.authenticate

class LoginViewModel: ViewModel(){
    var authStatus by mutableStateOf<String>(value= "")


    fun login(user: String, password: String, toHome:()->Unit) {
        if (authenticate(user,password)){
            toHome()
        }else{
            authStatus="Credenciales Inválidas"
        }

    }

}
