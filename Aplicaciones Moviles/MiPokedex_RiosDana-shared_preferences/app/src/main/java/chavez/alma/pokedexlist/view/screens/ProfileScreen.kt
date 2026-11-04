package chavez.alma.pokedexlist.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import chavez.alma.pokedexlist.ui.theme.Pink40
import chavez.alma.pokedexlist.ui.theme.Typography
import com.tu_paquete.pokedexlist.viewmodel.UserViewModel

@Composable
fun ProfileScreen(
    innerPadding: PaddingValues,
    userViewModel: UserViewModel = viewModel()
) {
    val user = userViewModel.currentUser
    val nombre = user?.name ?: "Nombre Usuario"
    val mail = user?.email ?: "usuario@mail.com"

    val image = if (user != null) userViewModel.companion.image else "No selected"
    val pokemonName = if (user != null) userViewModel.companion.name else "No Selected"

    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            nombre, style = Typography.titleLarge, color = Pink40
        )
        Text(
            mail, style = Typography.displayLarge, color = Pink40
        )

        Spacer(Modifier.size(50.dp))
        Text("Mi compañero", style = Typography.titleLarge)
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(PaddingValues(20.dp))
}
