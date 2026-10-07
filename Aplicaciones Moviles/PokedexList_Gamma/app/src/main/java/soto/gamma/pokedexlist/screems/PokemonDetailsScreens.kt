package soto.gamma.pokedexlist.screems


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import soto.gamma.pokedexlist.domain.Pokemon


@Composable
fun PokemonDetailScreen(innerPading: PaddingValues, pokemon: Pokemon) {

    Column() {
        Text(pokemon.name)
        Image(painterResource(pokemon.image), contentDescription = "${pokemon.name} image")
    }
}