package com.example.nerenmicrofinance

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "login") {
        composable("login") {
            LoginScreen { isAdmin ->
                if (isAdmin) {
                    navController.navigate("admin")
                } else {
                    navController.navigate("user")
                }
            }
        }
        composable("admin") {
            AdminScreen()
        }
        composable("user") {
            UserScreen()
        }
    }
}