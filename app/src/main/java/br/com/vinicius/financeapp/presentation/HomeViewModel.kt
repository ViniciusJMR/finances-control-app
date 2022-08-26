package br.com.vinicius.financeapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import br.com.vinicius.financeapp.data.model.Card
import br.com.vinicius.financeapp.domain.State
import br.com.vinicius.financeapp.domain.card.InsertUserCardUseCase
import br.com.vinicius.financeapp.domain.card.ListUserCardsUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    app: Application,
    private val listUserCardsUseCase: ListUserCardsUseCase,
): AndroidViewModel(app){
    private val _cards = MutableLiveData<State<List<Card>>>()
    val cards: LiveData<State<List<Card>>> = _cards

    fun getCardList() {
        viewModelScope.launch {
            listUserCardsUseCase()
                .onStart {
                    _cards.postValue(State.Loading)
                }
                .catch {
                    _cards.postValue(State.Error(it))
                }
                .collect{
                    _cards.postValue(State.Success(it))
                }
        }

    }


}