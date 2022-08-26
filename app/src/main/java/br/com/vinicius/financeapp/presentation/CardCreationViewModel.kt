package br.com.vinicius.financeapp.presentation

import android.app.Application
import androidx.lifecycle.*
import br.com.vinicius.financeapp.data.model.dto.CardDto
import br.com.vinicius.financeapp.domain.State
import br.com.vinicius.financeapp.domain.card.InsertUserCardUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CardCreationViewModel(
    app: Application,
    private val insertUserCardUseCase: InsertUserCardUseCase
): AndroidViewModel(app) {

    private val _card = MutableLiveData<State<Unit>>()
    val card: LiveData<State<Unit>> = _card

    fun insertCard(card: CardDto){
        viewModelScope.launch {
            insertUserCardUseCase(card)
                .onStart {
                    _card.postValue(State.Loading)
                }
                .catch {
                    _card.postValue(State.Error(it))
                }
                .collect{
                    _card.postValue(State.Success(it))
                }
        }
    }
}