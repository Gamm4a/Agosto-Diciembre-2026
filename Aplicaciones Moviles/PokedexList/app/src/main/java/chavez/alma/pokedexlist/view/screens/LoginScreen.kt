package chavez.alma.pokedexlist.view.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Button
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import chavez.alma.pokedexlist.model.data.UserViewModel


@Composable
fun LoginScreen(innerPadding: PaddingValues,
                onNavigateToMenu:()-> Unit,
                viewModel: UserViewModel = viewModel(),
                ) {
    var user by remember { mutableStateOf("") }
    var password = remember { TextFieldState() }

    if (viewModel.isLoggedIn()){
        onNavigateToMenu()
    }else {

        Column(Modifier.fillMaxWidth().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                value = user, onValueChange = { it -> user = it },
                label = {
                    Text("Correo Electrónico")
                },

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            SecureTextField(state = password,label = {
                    Text("Contrasenia")
                }, textObfuscationMode = TextObfuscationMode.RevealLastTyped,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(onClick = {
                viewModel.login(user, password.text as String)
                if (!viewModel.loginError) {
                    onNavigateToMenu()
                }
            }) {
                Text("Seciar Inisión")
            }

            Spacer(Modifier.size(40.dp))
            Text(
                viewModel.errorDescription, color = Color.Red,
                fontStyle = FontStyle.Italic
            )

        }
    }
}