package soto.gamma.thecheezery.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.thecheezery.ui.theme.Dusty_white
import soto.gamma.thecheezery.ui.theme.Less_Purple
import soto.gamma.thecheezery.ui.theme.Very_purple
import soto.gamma.thecheezery.viewmodel.CheezeryViewModel

@Composable
fun AddComboScreen(
    innerPadding: PaddingValues,
    viewModel: CheezeryViewModel
) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var selectedProductIds by remember { mutableStateOf(setOf<Int>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dusty_white)
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Text(
            text = "Create Combo",
            fontSize = 32.sp,
            color = Less_Purple
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Combo name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(viewModel.products) { product ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(product.name)
                    Checkbox(
                        checked = product.id in selectedProductIds,
                        onCheckedChange = { checked ->
                            selectedProductIds =
                                if (checked) selectedProductIds + product.id
                                else selectedProductIds - product.id
                        }
                    )
                }
            }

            if (viewModel.combos.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Saved combos", fontSize = 20.sp)
                }
                items(viewModel.combos) { combo ->
                    Text(
                        text = "${combo.name} - $${combo.price}",
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }

        Button(
            onClick = {
                val parsedPrice = price.toDoubleOrNull()
                if (name.isNotBlank() && parsedPrice != null && selectedProductIds.isNotEmpty()) {
                    viewModel.createCombo(name.trim(), parsedPrice, selectedProductIds.toList())
                    name = ""
                    price = ""
                    selectedProductIds = emptySet()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Very_purple)
        ) {
            Text("Save Combo")
        }
    }
}
