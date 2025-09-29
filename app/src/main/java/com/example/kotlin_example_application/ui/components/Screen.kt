package com.example.kotlin_example_application.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {
    data object Home : Screen(
        route = "home",
        title = "Главная",
        icon = Icons.Default.Home
    )

    data object Cart : Screen(
        route = "cart",
        title = "Корзина",
        icon = Icons.Default.ShoppingCart
    )

    data object Profile : Screen(
        route = "profile",
        title = "Профиль",
        icon = Icons.Default.Person
    )

    data object Product: Screen("product") {
        const val ARG_PRODUCT_ID = "productId"
        fun routeWithArgs(productId: String) = "$route/$productId"
    }
}