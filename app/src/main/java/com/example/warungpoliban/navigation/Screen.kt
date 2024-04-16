package com.example.warungpoliban.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.warungpoliban.detailHalaman.DetailHalaman
import com.example.warungpoliban.home.Home

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
}

@Composable
fun SetupNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            Home(navController)
        }
        composable(Screen.Detail.route) {
            DetailHalaman(navController)
        }
    }
}
