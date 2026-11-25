package soto.gamma.biometricauth.view.screens

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import soto.gamma.biometricauth.viewmodel.LoginViewModel
import java.util.concurrent.Executor

@Composable
fun LoginScreen(
    innerPadding: PaddingValues,
    onSuccessfulLogin: () -> Unit,
    loginViewModel: LoginViewModel = viewModel()
) {

    var user = remember { TextFieldState() }
    var password = remember { TextFieldState() }
    val context = LocalContext.current


    var isBiometricAvailable by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        val biometricManager = BiometricManager.from(context)
        when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                loginViewModel.authStatus = "Biométricos disponibles, preciona el Botón"
                isBiometricAvailable = true
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                loginViewModel.authStatus = "El celular no cuenta con sensor biometrico"
                isBiometricAvailable = false

            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                loginViewModel.authStatus =
                    "La bometrica no se encuentra disponible, inicia tus credenciales"
                isBiometricAvailable = false
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                loginViewModel.authStatus =
                    "no hay datos biométricos disponibles en el dispositivo. Ve a configuracion para registrarlos"
                isBiometricAvailable = false
            }

        }
    }

    val activity = context as FragmentActivity
    val executor: Executor = ContextCompat.getMainExecutor(context)
    val biometricPrompt = remember {
        BiometricPrompt(
            activity, executor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    loginViewModel.authStatus = "Error: ${errString}"
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                }

                override fun onAuthenticationFailed() {
                    loginViewModel.authStatus = "Fallo en las credenciales, intenta de nuevo"
                }

            }

        )
    }
    val promptInfo= remember{
        BiometricPrompt.PromptInfo.Builder()
            .setTitle("Autenticación Biométrica")
            .setSubtitle("Usa tu huella o reconocimiento facil")
            .setDescription("Coloca tu dedo en el sensor o mira a la camara sin lentes oscuros")
            .setNegativeButtonText("Cancelar")
            .build()
    }





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

        Button({
            loginViewModel.login(
                user.text.toString(),
                password.text.toString(),
                onSuccessfulLogin
            )
        }) {
            Text("Iniciar sesión")
        }


        Button({biometricPrompt.authenticate(promptInfo)}, enabled = isBiometricAvailable) {
            
        }



    }



}