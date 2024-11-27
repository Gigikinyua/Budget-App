package com.jemimah.budgetapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jemimah.budgetapp.database.dao.BudgetDao
import com.jemimah.budgetapp.model.BudgetItem
import com.jemimah.budgetapp.model.Transaction

@Database(entities = [BudgetItem::class, Transaction::class], version = 1, exportSchema = false)
abstract class BudgetDatabase : RoomDatabase() {
    abstract fun budgetDao(): BudgetDao
}