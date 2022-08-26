package br.com.vinicius.financeapp.domain.card

import androidx.lifecycle.LiveData
import br.com.vinicius.financeapp.data.local.repository.Repository
import br.com.vinicius.financeapp.data.model.Card
import br.com.vinicius.financeapp.domain.UseCase
import kotlinx.coroutines.flow.Flow

class ListUserCardsUseCase(
    private val cardRepo: Repository<Card>
): UseCase.NoParam<List<Card>>() {
    override suspend fun execute(): Flow<List<Card>> =
        cardRepo.getAll()
}