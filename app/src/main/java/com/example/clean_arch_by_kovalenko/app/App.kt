package com.example.clean_arch_by_kovalenko.app

import android.app.Application
import com.example.clean_arch_by_kovalenko.di.appModule
import com.example.clean_arch_by_kovalenko.di.dataModule
import com.example.clean_arch_by_kovalenko.di.domainModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR) // with DEBUG - crashing
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModel))
        }
    }
}