package soto.gamma.pokedexlist.screems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import soto.gamma.pokedexlist.data.getFavoritePokemons
import soto.gamma.pokedexlist.data.pokemonList


@Composable
fun MenuPokedexScreen(InnerPadding: PaddingValues, onNavigateToDetail:(id:Int)-> Unit){
    Column() {
        Text("Favorito")
        //FavoritesRow(getFavoritePokemons())
        Spacer(Modifier.size(15.dp))

        Text("All Pokemons")
       // PokedexGrid(pokemonList)


    }
}

@Preview(showBackground = true)
@Composable
fun screenPreview(){
    //menuPokedexPreview(PaddingValues(10.dp,15.dp))
}





