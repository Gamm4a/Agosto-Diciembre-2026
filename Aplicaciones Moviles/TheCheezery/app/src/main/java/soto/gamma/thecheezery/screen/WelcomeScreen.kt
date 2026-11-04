package soto.gamma.thecheezery.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.thecheezery.R
import soto.gamma.thecheezery.ui.theme.Dusty_white
import soto.gamma.thecheezery.ui.theme.Very_purple

@Composable
fun WelcomeScreen(
    innerPadding: PaddingValues,
    onStartClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dusty_white)
            .padding(innerPadding)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.the_cheezery),
            contentDescription = "Logo"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onStartClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Very_purple
            ),
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "START",
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen(PaddingValues(10.dp, 10.dp), {})
}