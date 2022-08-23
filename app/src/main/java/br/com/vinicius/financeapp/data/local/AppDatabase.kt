package br.com.vinicius.financeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.vinicius.financeapp.data.local.dao.CardDao
import br.com.vinicius.financeapp.data.model.Card

@Database(
    entities = [Card::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cardDao(): CardDao
}