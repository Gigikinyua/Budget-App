package com.jemimah.budgetapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import com.jemimah.budgetapp.viewModel.BudgetViewModel

@Composable
fun AddBudgetItemScreen(
    viewModel: BudgetViewModel,
    onSubmit: () -> Unit
) {
    var itemName by remember { mutableStateOf("") }
    var allocation by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Add New Budget Item", style = MaterialTheme.typography.h6)
        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = allocation,
            onValueChange = { allocation = it },
            label = { Text("Allocation (Ksh)") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                val allocationValue = allocation.toDoubleOrNull()
                if (!itemName.isBlank() && allocationValue != null) {
                    viewModel.addBudgetItem(BudgetItem(itemName, allocationValue))
                    onSubmit()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create New Budget Item")
        }
    }
}