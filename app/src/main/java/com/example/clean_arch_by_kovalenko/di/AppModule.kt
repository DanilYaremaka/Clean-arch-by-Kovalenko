package com.example.clean_arch_by_kovalenko.di

import android.content.Context
import com.example.clean_arch_by_kovalenko.domain.usecase.GetUserNameUseCase
import com.example.clean_arch_by_kovalenko.domain.usecase.SaveUserNameUseCase
import com.example.clean_arch_by_kovalenko.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase, saveUserNameUseCase)
    }
}