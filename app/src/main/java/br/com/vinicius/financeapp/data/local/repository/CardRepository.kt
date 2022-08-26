package br.com.vinicius.financeapp.data.local.repository

import android.util.Log
import br.com.vinicius.financeapp.data.local.AppDatabase
import br.com.vinicius.financeapp.data.local.dao.CardDao
import br.com.vinicius.financeapp.data.model.Card
import kotlinx.coroutines.flow.flow

class CardRepository(
    private val cardDao: CardDao
): Repository<Card> {
    override suspend fun getAll() = flow {
        val cards= cardDao.getAllCards()
        emit(cards)
    }

    override suspend fun insert(item: Card) = flow {
        cardDao.insert(item)
        emit(Unit)
    }
}