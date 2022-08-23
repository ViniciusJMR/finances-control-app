package br.com.vinicius.financeapp

import android.app.Application
import br.com.vinicius.financeapp.data.local.di.DataModule
import br.com.vinicius.financeapp.domain.di.DomainModule
import br.com.vinicius.financeapp.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        PresentationModule.load()
        DomainModule.load()
    }
}