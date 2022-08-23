package br.com.vinicius.financeapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.vinicius.financeapp.data.model.Card
import br.com.vinicius.financeapp.domain.State
import br.com.vinicius.financeapp.domain.card.ListUserCardsUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val listUserCardsUseCase: ListUserCardsUseCase
): ViewModel(){
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
                    _cards.postValue(State.Success(it.value))
                }
        }

    }

}