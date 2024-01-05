package com.raiseralex.coda_pizza // ktlint-disable package-name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raiseralex.coda_pizza.ui.PizzaBuilderScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             /* Coda_PizzaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ToppingCell(topping = Topping.Pepperoni, placement = ToppingPlacement.Left, onClickTipping = {} )
                }
            } */
            PizzaBuilderScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PizzaBuilderScreen()
}