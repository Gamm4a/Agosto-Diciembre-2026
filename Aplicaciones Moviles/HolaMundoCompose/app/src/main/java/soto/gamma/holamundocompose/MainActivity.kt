package soto.gamma.holamundocompose

import android.graphics.Color
import android.graphics.Color.RED
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import soto.gamma.holamundocompose.components.ProfileInfo
import soto.gamma.holamundocompose.ui.theme.HolaMundoComposeTheme
import soto.gamma.holamundocompose.ui.theme.Pink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(15.dp)
            .background(Pink,RectangleShape)
            .alpha(0.5F)

        )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HolaMundoComposeTheme {
        Greeting("Android")
    }
    ProfileInfo("Gamma", 21, "18/10",R.drawable.spiderman)
}