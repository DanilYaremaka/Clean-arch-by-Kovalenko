package com.example.clean_arch_by_kovalenko.di

import com.example.clean_arch_by_kovalenko.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}