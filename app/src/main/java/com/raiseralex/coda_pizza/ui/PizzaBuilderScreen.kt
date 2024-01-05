package com.raiseralex.coda_pizza.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raiseralex.coda_pizza.R
import com.raiseralex.coda_pizza.model.Pizza
import com.raiseralex.coda_pizza.model.Topping
import java.text.NumberFormat

@Preview
@Composable
fun PizzaBuilderScreen(
    modifier: Modifier = Modifier,
) {
    // var pizza by remember { mutableStateOf(Pizza()) }
    var pizza by rememberSaveable { mutableStateOf(Pizza()) }
    Column(
        modifier = modifier,
    ) {
        ToppingsList(
            pizza = pizza,
            onEditPizza = { pizza = it },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true),
        )
        OrderButton(
            pizza = pizza,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
    }
}

@Composable
private fun ToppingsList(
    pizza: Pizza,
    onEditPizza: (Pizza) -> Unit,
    modifier: Modifier = Modifier,
) {
    /* var showToppingPlacementDialog by rememberSaveable {
        mutableStateOf(false)
    }*/

    var toppingBeingAdded by rememberSaveable {
        mutableStateOf<Topping?>(null)
    }
    toppingBeingAdded?.let { topping ->
        ToppingPlacementDialog(
            topping = topping,
            onDismissRequest = {
                toppingBeingAdded = null
            },
        )
    }

    LazyColumn(modifier = modifier) {
        items(Topping.values()) { topping ->
            ToppingCell(
                topping = topping,
                placement = pizza.toppings[topping],
                onClickTopping = {
                    toppingBeingAdded = topping
                },
                modifier = modifier,
            )
        }
    }
}

@Composable fun OrderButton(
    pizza: Pizza,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ },
    ) {
        val currencyFormatter = remember { NumberFormat.getCurrencyInstance() }
        val price = currencyFormatter.format(pizza.price)
        Text(text = stringResource(id = R.string.place_order_button, price).toUpperCase(Locale.current))
    }
}

/*= Pizza(
    toppings = mapOf(
        Topping.Pepperoni to ToppingPlacement.All,
        Topping.Pineapple to ToppingPlacement.All,
    ),
)*/