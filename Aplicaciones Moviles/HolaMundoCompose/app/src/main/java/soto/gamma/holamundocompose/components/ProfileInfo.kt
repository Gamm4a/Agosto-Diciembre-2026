package soto.gamma.holamundocompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.holamundocompose.R
import soto.gamma.holamundocompose.ui.theme.Pink

@Composable
fun ProfileInfo(name: String, age: Number, dob: String, image: Int){
    Box(Modifier.fillMaxWidth()){
    Image(painterResource(image),
        contentDescription = "Spiderman",
        Modifier.width(50.dp).align(Alignment.CenterStart)
        )


    Column(Modifier.align(Alignment.BottomEnd)){
        Text("${name}", color = Pink, fontSize = 20.sp)
        Row(Modifier.padding(top = 7.dp),
            horizontalArrangement = Arrangement.spacedBy(9.dp)){
            Text("${age} year" )
            Text("DOB: ${dob}")
        }
    }


    }


}



@Preview(showBackground = true)
@Composable
fun ProfileInfoPreview(){
    ProfileInfo("Gamma", 21, "18/10",R.drawable.spiderman)
}


