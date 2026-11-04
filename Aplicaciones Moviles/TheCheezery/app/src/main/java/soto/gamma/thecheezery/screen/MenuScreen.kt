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
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.thecheezery.R
import soto.gamma.thecheezery.ui.theme.Dusty_white
import soto.gamma.thecheezery.ui.theme.Very_purple

@Composable
fun MenuScreen(
    innerPadding: PaddingValues,
    onCategoryClick: (String) -> Unit,
    onCartClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dusty_white)
            .padding(innerPadding)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.the_cheezery),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                onCategoryClick("HOT_DRINKS")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Very_purple
            )
        ) {
            Text("Hot Drinks")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                onCategoryClick("COLD_DRINKS")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Very_purple
            )
        ) {
            Text("Cold Drinks")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                onCategoryClick("SALTIES")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Very_purple
            )
        ) {
            Text("Salties")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                onCategoryClick("SWEETS")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Very_purple
            )
        ) {
            Text("Sweets")
        }

        Spacer(modifier = Modifier.height(30.dp))

        FilledIconButton(
            onClick = onCartClick
        ) {

            Icon(
                painter = painterResource(R.drawable.cart),
                contentDescription = "Cart"
            )
        }
    }
}