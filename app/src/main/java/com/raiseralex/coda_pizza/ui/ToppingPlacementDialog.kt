package com.raiseralex.coda_pizza.ui // ktlint-disable package-name

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.raiseralex.coda_pizza.R
import com.raiseralex.coda_pizza.model.Topping
import com.raiseralex.coda_pizza.model.ToppingPlacement

@Composable
fun ToppingPlacementDialog(
    topping: Topping,
    onSetTippingPlacement: (placement: ToppingPlacement?) -> Unit,
    onDismissRequest: () -> Unit,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card {
            Column {
                val toppingName = stringResource(topping.toppingName)
                Text(
                    text = stringResource(id = R.string.placement_prompt, toppingName),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp),
                )
                ToppingPlacement.values().forEach { placement ->
                    ToppingPlacementOption(placementName = placement.label, onClick = {
                        onSetTippingPlacement(placement)
                        onDismissRequest()
                    })
                }
                ToppingPlacementOption(placementName = R.string.placement_none, onClick = {
                    onSetTippingPlacement(null)
                    onDismissRequest()
                })
            }
        }
    }
}

@Composable
private fun ToppingPlacementOption(
    @StringRes placementName: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = stringResource(id = placementName),
            modifier = Modifier.padding(8.dp),
        )
    }
}
