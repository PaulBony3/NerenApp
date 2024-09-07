package com.example.nerenmicrofinance

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User Dashboard") }
            )
        }
    ) { innerPadding ->
        // User content goes here
        // Use the innerPadding parameter to apply padding to the content
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Welcome to the User Dashboard")
        }
    }
}