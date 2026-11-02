package soto.gamma.myapplication.screen

import android.graphics.Paint
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.examencompose.Data.usuarioEjemplo
import soto.gamma.myapplication.R


@Composable
fun perfil(){
    Column() {
        Row() {
            image()
            followers()
        }
        description()
    }

}


@Composable
fun image(){
    Image(
        painter = painterResource(usuarioEjemplo.imagenPerfil),
        contentDescription = "Imagen de Perfil",
        Modifier
            .padding(4.dp)
            .clip(CircleShape)
            .size(70.dp)
    )
}


@Composable
fun followers(){

    Column() {
        Text(usuarioEjemplo.nombreReal, fontSize = 17.sp)
        Row(){
            Column() {
                Text("${usuarioEjemplo.numeroPosts}")
                Text("Post")
            }
            Spacer(Modifier.width(30.dp))
            Column() {
                Text("${usuarioEjemplo.numeroSeguidores}")
                Text("Followers")
            }
            Spacer(Modifier.width(15.dp))
            Column() {
                Text("${usuarioEjemplo.numeroSeguidos}")
                Text("Following")
            }

        }

    }
}

@Composable
fun description(){
    Column() {
        Text("${usuarioEjemplo.biografia}", fontSize = 13.sp)
        Text("«Estos son los links", color = Color.Blue, fontSize = 9.sp)
    }
}

