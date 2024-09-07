package com.example.nerenmicrofinance.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(startDestination: String = "borrowers") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("borrowers") {
            BorrowersScreen(
                borrowers = listOf("John Doe", "Jane Smith"), // Example data
                onAddBorrower = { /* Handle add borrower */ },
                onBorrowerClick = { borrower ->
                    navController.navigate("borrowerDetails/$borrower")
                }
            )
        }
        composable("borrowerDetails/{borrower}") { backStackEntry ->
            val borrower = backStackEntry.arguments?.getString("borrower")
            borrower?.let {
                BorrowerDetails(borrower = it)
            }
        }
    }
}