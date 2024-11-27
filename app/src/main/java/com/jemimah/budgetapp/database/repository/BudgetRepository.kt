package com.jemimah.budgetapp.database.repository

import com.jemimah.budgetapp.database.dao.BudgetDao
import com.jemimah.budgetapp.model.BudgetItem
import com.jemimah.budgetapp.model.Transaction
import kotlinx.coroutines.flow.Flow

class BudgetRepository(private val budgetDao: BudgetDao) {

    // Budget items
    suspend fun insertBudgetItem(budgetItem: BudgetItem) = budgetDao.insertBudgetItem(budgetItem)
    fun getAllBudgetItems(): Flow<List<BudgetItem>> = budgetDao.getAllBudgetItems()
    fun getTotalSpent(): Flow<Double> = budgetDao.getTotalSpent()

    // Transactions (Optional)
    suspend fun insertTransaction(transaction: Transaction) = budgetDao.insertTransaction(transaction)
    fun getRecentTransactions(): Flow<List<Transaction>> = budgetDao.getRecentTransactions()
}