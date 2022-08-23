package br.com.vinicius.financeapp.domain.card

import androidx.lifecycle.LiveData
import br.com.vinicius.financeapp.data.local.AppDatabase
import br.com.vinicius.financeapp.data.local.repository.Repository
import br.com.vinicius.financeapp.data.model.Card
import br.com.vinicius.financeapp.domain.UseCase
import kotlinx.coroutines.flow.Flow

class ListUserCardsUseCase(
    private val cardRepo: Repository<Card>
): UseCase.NoParam<LiveData<List<Card>>>() {
    override suspend fun execute(): Flow<LiveData<List<Card>>> =
        cardRepo.getAll()
}