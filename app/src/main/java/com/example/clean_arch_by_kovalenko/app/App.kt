package com.example.clean_arch_by_kovalenko.app

import android.app.Application
import com.example.clean_arch_by_kovalenko.di.AppComponent
import com.example.clean_arch_by_kovalenko.di.AppModule
import com.example.clean_arch_by_kovalenko.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}