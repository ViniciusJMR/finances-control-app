package br.com.vinicius.financeapp.data.local.di

import androidx.room.Room
import br.com.vinicius.financeapp.data.local.AppDatabase
import br.com.vinicius.financeapp.data.local.dao.CardDao
import br.com.vinicius.financeapp.data.local.repository.CardRepository
import br.com.vinicius.financeapp.data.local.repository.Repository
import br.com.vinicius.financeapp.data.model.Card
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModule {
    fun load() {
        loadKoinModules(localDataModules())
    }

    private fun localDataModules() = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                "finance_db"
            ).build()
        }

        single(qualifier = named("CARD_DAO")){
            val db = get<AppDatabase>()
            db.cardDao()
        }

        single<Repository<Card>>(qualifier = named("CARD_REPOSITORY")) {
            CardRepository(get(qualifier = named("CARD_DAO")))
        }
    }

}