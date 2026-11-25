package soto.gamma.biometricauth.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(innerPadding: PaddingValues, onExit: ()-> Unit){

    Column(
        Modifier.fillMaxSize()
            .padding(innerPadding)
    ) {
        Text("Hola :p")

        Spacer(Modifier.size(30.dp))

        Button(onExit) {
            Text("Cerrar Sesión")
        }
    }



}