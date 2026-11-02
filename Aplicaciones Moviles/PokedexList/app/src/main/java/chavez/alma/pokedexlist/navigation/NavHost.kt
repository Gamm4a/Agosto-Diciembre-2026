package chavez.alma.pokedexlist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import chavez.alma.pokedexlist.model.data.UserViewModel
import chavez.alma.pokedexlist.model.data.getPokemonByNumber
import chavez.alma.pokedexlist.view.screens.LoginScreen
import chavez.alma.pokedexlist.view.screens.MenuPokedexScreen
import chavez.alma.pokedexlist.view.screens.PokemonDetailScreen
import chavez.alma.pokedexlist.view.screens.PokemonHuntScreen

@Composable
fun MyApp(
    innerPadding: PaddingValues,
    userViewModel: UserViewModel
) {
    val navController = rememberNavController()
    val navigateToMenu = {
        navController.navigate(PokemonList)
    }

    NavHost(navController, startDestination = login) {
        composable<login> {
            LoginScreen(
                innerPadding,
                navigateToMenu,
                userViewModel
            )
        }


        composable<PokemonList> {
            MenuPokedexScreen(
                innerPadding = innerPadding,
                onNavigateToDetail = { id ->
                    navController.navigate(route = PokemonDetail(id))
                },
                onNavigateToHunt = { navController.navigate(route = PokemonHunt) }
            )
        }
        composable<PokemonDetail> { backStackEntry ->
            val detail: PokemonDetail = backStackEntry.toRoute()
            val pokemon = getPokemonByNumber(detail.pokemon)
            PokemonDetailScreen(innerPadding = innerPadding, pokemon = pokemon)
        }

        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding)
        }

    }
}
