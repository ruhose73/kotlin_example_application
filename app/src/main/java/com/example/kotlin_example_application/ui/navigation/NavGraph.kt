package com.example.kotlin_example_application.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_example_application.ui.components.BottomNavBar
import com.example.kotlin_example_application.ui.components.Screen
import com.example.kotlin_example_application.ui.screens.CartScreen
import com.example.kotlin_example_application.ui.screens.HomeScreen
import com.example.kotlin_example_application.ui.screens.ProductScreen
import com.example.kotlin_example_application.ui.screens.ProfileScreen


val bottomNavItems = listOf(
    Screen.Home,
    Screen.Cart,
    Screen.Profile
)

@Composable
fun AppNavGraph(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) {
            innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Cart.route) { CartScreen(navController) }
            composable(Screen.Profile.route) { ProfileScreen(navController) }
            composable  (
                route = "${Screen.Product.route}/{productId}"
            ) {
                    backStackEntity ->
                val productId = backStackEntity.arguments?.getString("productId") ?: ""
                ProductScreen(navController, productId)
            }
        }
    }
}