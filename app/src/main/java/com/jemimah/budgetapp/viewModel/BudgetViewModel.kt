package com.jemimah.budgetapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jemimah.budgetapp.database.repository.BudgetRepository
import com.jemimah.budgetapp.model.BudgetItem
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.Collections.emptyList

class BudgetViewModel(private val repository: BudgetRepository) : ViewModel() {

    // Observing the budget items
    val budgetItems: StateFlow<List<BudgetItem>> = repository.getAllBudgetItems()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    // Observing total spent and calculating remaining budget
    val totalSpent: StateFlow<Double> = repository.getTotalSpent()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), 0.0)
    val remainingBudget: StateFlow<Double> = totalSpent.map { spent -> 125560 - spent }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), 125560.0)

    // Add a new budget item
    fun addBudgetItem(item: BudgetItem) {
        viewModelScope.launch {
            repository.insertBudgetItem(item)
        }
    }
}