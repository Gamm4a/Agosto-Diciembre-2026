package soto.gamma.thecheezery.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import soto.gamma.thecheezery.screen.CartScreen
import soto.gamma.thecheezery.screen.LoginScreen
import soto.gamma.thecheezery.screen.MenuScreen
import soto.gamma.thecheezery.screen.ShowProductsScreen
import soto.gamma.thecheezery.screen.WelcomeScreen
import soto.gamma.thecheezery.viewmodel.CheezeryViewModel

@Composable
fun MyApp(
    innerPadding: PaddingValues,
    viewModel: CheezeryViewModel
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Welcome
    ) {

        composable<Welcome> {

            WelcomeScreen(
                innerPadding = innerPadding,
                onStartClick = {
                    navController.navigate(Login)
                }
            )
        }

        composable<Login> {

            LoginScreen(
                innerPadding = innerPadding,
                onLoginSuccess = {
                    navController.navigate(Menu)
                }
            )
        }

        composable<Menu> {

            MenuScreen(
                innerPadding = innerPadding,

                onCategoryClick = { category ->

                    navController.navigate(
                        Products(category)
                    )
                },

                onCartClick = {
                    navController.navigate(Cart)
                }
            )
        }

        composable<Products> { backStackEntry ->

            val route: Products =
                backStackEntry.toRoute()

            ShowProductsScreen(
                innerPadding = innerPadding,
                category = route.category,
                viewModel = viewModel,
                onCartClick = {
                    navController.navigate(Cart)
                }
            )
        }

        composable<Cart> {

            CartScreen(
                innerPadding = innerPadding,
                viewModel = viewModel
            )
        }
    }
}
