package com.raiseralex.coda_pizza.ui // ktlint-disable package-name

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.raiseralex.coda_pizza.R
import com.raiseralex.coda_pizza.model.Pizza
import com.raiseralex.coda_pizza.model.Topping
import com.raiseralex.coda_pizza.model.ToppingPlacement.All
import com.raiseralex.coda_pizza.model.ToppingPlacement.Left
import com.raiseralex.coda_pizza.model.ToppingPlacement.Right

@Preview
@Composable
private fun PizzaHeroImagePreview() {
    PizzaHeroImage(
        pizza = Pizza(
            toppings = mapOf(
                Topping.Pineapple to All,
                Topping.Pepperoni to Left,
                Topping.Basil to Right,
            ),
        ),
    )
}

@Composable
fun PizzaHeroImage(
    pizza: Pizza,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .aspectRatio(1f),
    ) {
        Image(
            painter = painterResource(id = R.drawable.pizza_crust),
            contentDescription = stringResource(id = R.string.pizza_preview),
            modifier = modifier.fillMaxSize(),
        )

        pizza.toppings.forEach { (topping, placement) ->
            Image(
                painter = painterResource(id = topping.pizzaOverlayImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.focusable(false)
                    .aspectRatio(
                        when (placement) {
                            Left, Right -> 0.5f
                            All -> 1.0f
                        },
                    ).align(
                        when (placement) {
                            Left -> Alignment.CenterStart
                            Right -> Alignment.CenterEnd
                            All -> Alignment.Center
                        },
                    ),
                alignment = when (placement) {
                    Left -> Alignment.TopStart
                    Right -> Alignment.TopEnd
                    All -> Alignment.Center
                },
            )
        }
    }
}
