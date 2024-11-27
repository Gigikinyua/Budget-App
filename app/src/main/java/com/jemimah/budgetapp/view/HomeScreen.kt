package com.jemimah.budgetapp.view

// Other imports you may need for your app
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jemimah.budgetapp.viewModel.BudgetViewModel

@Composable
fun HomeScreen(
    viewModel: BudgetViewModel,
    onAddBudgetClick: () -> Unit
) {
    val remainingBudget by viewModel.remainingBudget.collectAsState()
    val budgetItems by viewModel.budgetItems.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "$remainingBudget Ksh. remaining in your monthly budget",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Total Spent This Month: ${125560 - remainingBudget}",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // List of Budget Items
        Text(text = "Categories:")
        budgetItems.forEach { item ->
            Text(text = "${item.name}: ${item.allocation} Ksh")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = onAddBudgetClick, modifier = Modifier.fillMaxWidth()) {
            Text("Add New Budget")
        }
    }
}