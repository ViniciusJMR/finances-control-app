package br.com.vinicius.financeapp.presentation.di

import br.com.vinicius.financeapp.presentation.CardCreationViewModel
import br.com.vinicius.financeapp.presentation.HomeViewModel
import get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

object PresentationModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule() = module {
        viewModel {
            HomeViewModel(get(), get())
        }
        viewModel {
            CardCreationViewModel(get(), get())
        }
    }

}