package com.example.nerenmicrofinance.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun BorrowersScreen(borrowers: List<String>, onAddBorrower: () -> Unit, onBorrowerClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Borrowers", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        
        borrowers.forEach { borrower ->
            Text(
                text = borrower,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onBorrowerClick(borrower) }
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(onClick = onAddBorrower) {
            Text("Add New Borrower")
        }
    }
}

@Composable
fun BorrowerDetails(borrower: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Borrower Details", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Name: $borrower")
        // Add more details as needed
    }
}