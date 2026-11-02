package soto.gamma.myapplication.screen.post

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.helper.widget.Grid
import soto.gamma.examencompose.Data.Post
import soto.gamma.examencompose.Data.publicaciones
import soto.gamma.examencompose.Data.usuarioEjemplo
import soto.gamma.myapplication.R
import soto.gamma.myapplication.screen.image


@Composable
fun posts() {

    LazyColumn() {


    }
}

@Composable
fun publicacionesList(publicaciones: List<Post>) {
    Column {
        publicaciones.forEach { publicacion ->

        }
    }
}

@Composable
fun MessageRow(
    publicacion: Post
) {
    Card() {
        Column(
            verticalArrangement = Arrangement.Center
        ) {

        }
    }
}


@Preview
@Composable
fun preview() {
    posts()
}



