package com.example.nerenmicrofinance

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.text.font.FontWeight
import com.example.nerenmicrofinance.ui.theme.BorrowersScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var currentScreen by remember { mutableStateOf("AdminDashboard") }

    val menuItems = listOf(
        "Borrowers",
        "Loans",
        "Expense Categories",
        "Expenses",
        "Loan Agreement Forms",
        "Loan Settlement Forms",
        "Repayments",
        "Reports",
        "Settings"
    )

    val borrowers = listOf("John Doe", "Jane Smith", "Alice Johnson") // Example borrowers

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier.padding(16.dp)) {
                    menuItems.forEach { item ->
                        Text(
                            text = item,
                            modifier = Modifier
                                .clickable {
                                    currentScreen = item
                                    scope.launch { drawerState.close() }
                                }
                                .padding(8.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Admin Dashboard") },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(Icons.Default.Menu, contentDescription = "Menu")
                            }
                        }
                    )
                }
            ) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    when (currentScreen) {
                        "Borrowers" -> BorrowersScreen(
                            borrowers = borrowers,
                            onAddBorrower = { /* Handle add borrower action */ },
                            onBorrowerClick = { borrower ->
                                // Navigate to Borrower Details screen
                                currentScreen = "BorrowerDetails"
                                // You can also pass the borrower details if needed
                            }
                        )
                        else -> Text("Welcome to the Admin Dashboard")
                    }
                }
            }
        }
    )
}