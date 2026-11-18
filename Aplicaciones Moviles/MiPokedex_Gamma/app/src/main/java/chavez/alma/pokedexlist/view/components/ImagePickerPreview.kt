package chavez.alma.pokedexlist.view.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlin.contracts.contract

@Composable
fun ImagePickerPreview(currentUri: Uri,
                       onUriChange: (uri:Uri)-> Unit,
                       pickerModifier: Modifier? = null,
                       previewModifier: Modifier? = null,
                       ){
    val context = LocalContext.current
    val imagePickerLauncher= rememberLauncherForActivityResult(
        contract= ActivityResultContracts.PickVisualMedia(),
        onResult = {uri -> onUriChange(uri)}
    )

}