package soto.gamma.biometricauth.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Button
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import soto.gamma.biometricauth.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    innerPadding: PaddingValues,
    onSuccessfulLogin: () -> Unit,
    loginViewModel: LoginViewModel = viewModel()
) {

    var user = remember { TextFieldState() }
    var password = remember { TextFieldState() }


    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TextField(user, label = { Text("Correo Electronico") })
        SecureTextField(
            password, label = { Text("Contraseña") },
            textObfuscationMode = TextObfuscationMode.RevealLastTyped
        )
    }

    Button({
        loginViewModel.login(
            user.text.toString(),
            password.text.toString(),
            onSuccessfulLogin
        )
    }) {
        Text("Iniciar sesión")
    }


}