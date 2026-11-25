package soto.gamma.biometricauth.navegation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import soto.gamma.biometricauth.view.screens.HomeScreen
import soto.gamma.biometricauth.view.screens.LoginScreen

@Composable
fun BiometricNavegation(innerPadding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(innerPadding, { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(innerPadding, onExit = { navController.navigate(Login) })
        }


    }


}