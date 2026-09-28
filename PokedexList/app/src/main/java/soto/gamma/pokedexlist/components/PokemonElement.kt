package soto.gamma.pokedexlist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.pokedexlist.data.Pokemons
import soto.gamma.pokedexlist.data.bulbasaur
import soto.gamma.pokedexlist.domain.Pokemon
import soto.gamma.pokedexlist.ui.theme.Green

@Composable
fun PokemonRow(pokemon: Pokemon){
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween){
        Image(painterResource(pokemon.image),
            contentDescription = "${pokemon.name} image",
            Modifier.width(80.dp)
                .padding(10.dp))


        Column(Modifier.fillMaxWidth(.6f)){
            Text(pokemon.name)
            Text(pokemon.description, fontSize = 10.sp)
            Row(Modifier.fillMaxWidth(0.80f),horizontalArrangement = Arrangement.SpaceAround) {
                Text("height: ${pokemon.height}")

                Text("Weight: ${pokemon.weight}")
            }
        }

        Text("${pokemon.number}",
            Modifier.background(Green, CircleShape)
                .padding(5.dp,2.dp))
    }




}

@Preview(showBackground = true)
@Composable
fun PokemonElementPreview(){
    PokemonRow(bulbasaur)
}

