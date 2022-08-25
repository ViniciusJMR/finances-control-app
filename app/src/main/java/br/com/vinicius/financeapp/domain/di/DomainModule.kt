package br.com.vinicius.financeapp.domain.di

import br.com.vinicius.financeapp.domain.card.InsertUserCardUseCase
import br.com.vinicius.financeapp.domain.card.ListUserCardsUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule() = module {
        factory {
            ListUserCardsUseCase(get(qualifier = named("CARD_REPOSITORY")))
        }
        factory {
            InsertUserCardUseCase(get(qualifier = named("CARD_REPOSITORY")))
        }
    }
}