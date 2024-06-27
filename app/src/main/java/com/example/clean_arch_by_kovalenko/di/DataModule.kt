package com.example.clean_arch_by_kovalenko.di

import android.content.Context
import com.example.clean_arch_by_kovalenko.data.repository.UserRepositoryImpl
import com.example.clean_arch_by_kovalenko.data.storage.UserStorage
import com.example.clean_arch_by_kovalenko.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.clean_arch_by_kovalenko.domain.repository.UserRepository
import dagger.Module
import dagger.Provides


@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context)
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }
}