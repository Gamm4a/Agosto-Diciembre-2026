package soto.gamma.pokedexlist.navegation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import soto.gamma.pokedexlist.screems.MenuPokedexScreen

@Composable
fun MyApp(innerPadding: PaddingValues,){
    val navController = rememberNavController()
    NavHost(navController,startDestination= PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding, onNavigateToDetail =
                {id->navController.navigate(route= PokemonDetail(id))})
        }
        composable<PokemonDetail> {

        }


    }
}