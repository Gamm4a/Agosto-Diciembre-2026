package soto.gamma.thecheezery.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.thecheezery.R
import soto.gamma.thecheezery.model.Product
import soto.gamma.thecheezery.ui.theme.Dusty_white
import soto.gamma.thecheezery.ui.theme.Less_Purple
import soto.gamma.thecheezery.viewmodel.CheezeryViewModel

@Composable
fun CartScreen(
    innerPadding: PaddingValues,
    viewModel: CheezeryViewModel
) {

    val cartProducts = viewModel.cartProducts

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dusty_white)
            .padding(innerPadding)
            .padding(16.dp)
    ) {

        Text(
            text = "Shopping Cart",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (cartProducts.isEmpty()) {

            Text(
                text = "Add some products to your order!",
                fontSize = 20.sp
            )

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(cartProducts) { product ->

                    CartItem(
                        product = product,
                        onDelete = {
                            viewModel.removeFromCart(product)
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Total",
                fontSize = 40.sp
            )

            Text(
                text = "$${viewModel.calculateTotal()}",
                fontSize = 50.sp,
                color = Less_Purple
            )
        }
    }
}

@Composable
private fun CartItem(
    product: Product,
    onDelete: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(
                    product.imageRes
                ),
                contentDescription = product.name,
                modifier = Modifier.size(80.dp)
            )

            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {

                Text(
                    text = product.name,
                    fontSize = 20.sp
                )

                Text(
                    text = "$${product.price}",
                    color = Less_Purple,
                    fontSize = 20.sp
                )
            }
        }

        IconButton(
            onClick = onDelete
        ) {

            Icon(
                painter = painterResource(
                    R.drawable.delete
                ),
                contentDescription = "Delete",
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}