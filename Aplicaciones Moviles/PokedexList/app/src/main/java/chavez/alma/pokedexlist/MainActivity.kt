package chavez.alma.pokedexlist

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.InnerShadowScope
import androidx.compose.ui.tooling.preview.Preview
import chavez.alma.pokedexlist.model.data.UserViewModel
import chavez.alma.pokedexlist.model.data.Users
import chavez.alma.pokedexlist.model.preferences.ARCHIVO
import chavez.alma.pokedexlist.navigation.MyApp
import chavez.alma.pokedexlist.ui.theme.PokedexListTheme
import chavez.alma.pokedexlist.view.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users= Users(this)
        val usersViewModel = UserViewModel(users)
        enableEdgeToEdge()
        setContent {
            PokedexListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(innerPadding, usersViewModel)

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexListTheme {

    }
}
