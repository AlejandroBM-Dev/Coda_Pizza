package com.raiseralex.coda_pizza.model // ktlint-disable package-name

import androidx.annotation.StringRes
import com.raiseralex.coda_pizza.R

enum class ToppingPlacement(
    @StringRes val label: Int,
) {
    Left(R.string.placement_left),
    Right(R.string.placement_right),
    All(R.string.placement_all),
}
