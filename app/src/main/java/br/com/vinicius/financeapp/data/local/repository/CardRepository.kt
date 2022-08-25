package br.com.vinicius.financeapp.data.local.repository

import br.com.vinicius.financeapp.data.local.AppDatabase
import br.com.vinicius.financeapp.data.model.Card
import kotlinx.coroutines.flow.flow

class CardRepository(
    private val localDb: AppDatabase
): Repository<Card> {
    override suspend fun getAll() = flow {
        val cards= localDb.cardDao().getAllCards()
        emit(cards)
    }

    override suspend fun insert(item: Card) = flow {
        localDb.cardDao().insert(item)
        emit(Unit)
    }
}