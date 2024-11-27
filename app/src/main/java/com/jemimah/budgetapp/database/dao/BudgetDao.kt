package com.jemimah.budgetapp.database.dao

import androidx.room.*
import com.jemimah.budgetapp.model.BudgetItem
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    // Budget items
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudgetItem(budgetItem: BudgetItem)

    @Query("SELECT * FROM budget_items")
    fun getAllBudgetItems(): Flow<List<BudgetItem>>

    @Query("SELECT SUM(allocation) FROM budget_items")
    fun getTotalSpent(): Flow<Double>

    // Transactions (Optional)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: com.jemimah.budgetapp.model.Transaction)

    @Query("SELECT * FROM transactions ORDER BY date DESC LIMIT 10")
    fun getRecentTransactions(): Flow<List<com.jemimah.budgetapp.model.Transaction>>
}