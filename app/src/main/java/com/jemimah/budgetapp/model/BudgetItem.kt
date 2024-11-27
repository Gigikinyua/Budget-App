package com.jemimah.budgetapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget_items")
data class BudgetItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val allocation: Double
)