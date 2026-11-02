package soto.gamma.thecheezery.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.fromColorLong
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import soto.gamma.thecheezery.R
import soto.gamma.thecheezery.ui.theme.Purple_grey

@Composable
fun welcomeScreen(){

        Column() {
            Image(
                painter =
                    painterResource(R.drawable.the_cheezery),
                contentDescription = "imagen de inicio"
            )

            content()
        }





}


@Composable
private fun content(){

    Card(Modifier.padding(top = 50.dp).background()) {

        Column() {
            Text("Welcome to The Cheezery", color = Color.White)
            Text(
                "Home of the most wonderful deserts enver seen " +
                        "(and tasted) by the human being", color = Color.White
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun previewWelcomeScreen(){
    welcomeScreen()
}


