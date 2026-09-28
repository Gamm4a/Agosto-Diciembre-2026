package soto.gamma.myapplication.Components

import androidx.compose.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.myapplication.R

@Composable
fun CardPokemon() {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        // Fondo
        // Note: painterResource only supports VectorDrawables and rasterized assets (PNG/JPG/WEBP).
        // shape drawables are replaced with Compose's Brush.verticalGradient.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.purple),
                            colorResource(id = R.color.black)
                        )
                    )
                )
        )

        // Estrella
        Text(
            text = "⭐",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )

        // Nombre y número
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 24.dp, top = 70.dp)
        ) {

            Text(
                text = "Haunter",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "#093",
                fontSize = 20.sp
            )
        }

        // Imagen principal
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Haunter",
            modifier = Modifier
                .size(220.dp)
                .align(Alignment.TopCenter)
                .padding(top = 90.dp)
        )

        // Card inferior
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(
                topStart = 40.dp,
                topEnd = 40.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {

                Text(
                    text = "Fantasma / Veneno",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(
                            text = "Habilidad",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold
                        )

                        Text("Levitación")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(
                            text = "Altura",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold
                        )

                        Text("1.6 m")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(
                            text = "Peso",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold
                        )

                        Text("0.1 kg")
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = stringResource(R.string.descripcion),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(R.drawable.img_1),
                            contentDescription = "Gastly",
                            modifier = Modifier.size(100.dp)
                        )

                        Text("Gastly N.°092")
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(R.drawable.img_2),
                            contentDescription = "Gengar",
                            modifier = Modifier.size(100.dp)
                        )

                        Text("Gengar N.°094")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPokemonPreview(){
    CardPokemon()
}

