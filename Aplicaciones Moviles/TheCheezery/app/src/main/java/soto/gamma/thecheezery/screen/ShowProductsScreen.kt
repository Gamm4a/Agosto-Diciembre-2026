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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soto.gamma.thecheezery.R
import soto.gamma.thecheezery.model.Product
import soto.gamma.thecheezery.model.ProductCategory
import soto.gamma.thecheezery.ui.theme.DisabledGrey
import soto.gamma.thecheezery.ui.theme.Dusty_white
import soto.gamma.thecheezery.ui.theme.Less_Purple
import soto.gamma.thecheezery.ui.theme.Very_purple
import soto.gamma.thecheezery.viewmodel.CheezeryViewModel

@Composable
fun ShowProductsScreen(
    innerPadding: PaddingValues,
    category: String,
    viewModel: CheezeryViewModel,
    onCartClick: () -> Unit
) {

    val selectedCategory =
        ProductCategory.valueOf(category)

    val products =
        viewModel.getProductsByCategory(
            selectedCategory
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dusty_white)
            .padding(innerPadding)
            .padding(16.dp)
    ) {

        Text(
            text = category.replace("_", " "),
            fontSize = 32.sp,
            color = Less_Purple
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(products) { product ->

                ProductItem(
                    product = product,
                    onAddToCart = {
                        viewModel.addToCart(product)
                    }
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }
        }

        FloatingActionButton(
            onClick = onCartClick,
            containerColor = Very_purple,
            modifier = Modifier.align(
                Alignment.End
            )
        ) {

            Icon(
                painter = painterResource(
                    R.drawable.cart
                ),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ProductItem(
    product: Product,
    onAddToCart: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
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

            Column {

                Text(
                    text = product.name,
                    fontSize = 20.sp
                )

                Text(
                    text = "$${product.price}",
                    color = Less_Purple
                )
            }
        }

        FilledIconButton(
            onClick = onAddToCart,
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Very_purple,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = DisabledGrey
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.add_cart),
                contentDescription = null
            )
        }
    }
}