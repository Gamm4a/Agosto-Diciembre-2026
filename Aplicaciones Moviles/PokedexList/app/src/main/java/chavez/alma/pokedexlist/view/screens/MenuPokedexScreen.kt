package chavez.alma.pokedexlist.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chavez.alma.pokedexlist.view.components.FavoritesRow
import chavez.alma.pokedexlist.view.components.PokedexGrid
import chavez.alma.pokedexlist.model.data.getFavoritePokemons
import chavez.alma.pokedexlist.model.data.pokemonList

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (id: Int) -> Unit = {}){
    Column(modifier = Modifier.padding(innerPadding)) {
        Text("Favorite Pokemons")
        FavoritesRow(getFavoritePokemons(), onNavigateToDetail)
        Spacer(Modifier.size(15.dp))
        Text("All pokemons")
        PokedexGrid(pokemonList, onNavigateToDetail)
    }
}

@Preview(showBackground = true)
@Composable
fun screenPreview(){
    MenuPokedexScreen(
        innerPadding = PaddingValues(10.dp, 15.dp),
        onNavigateToDetail = {}
    )
}
