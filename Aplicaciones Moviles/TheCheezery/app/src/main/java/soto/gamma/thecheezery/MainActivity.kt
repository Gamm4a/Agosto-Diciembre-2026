package soto.gamma.thecheezery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import soto.gamma.thecheezery.navigation.MyApp
import soto.gamma.thecheezery.ui.theme.TheCheezeryTheme
import soto.gamma.thecheezery.viewmodel.CheezeryViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = CheezeryViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            TheCheezeryTheme {

                Scaffold { innerPadding ->

                    MyApp(
                        innerPadding = innerPadding,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}