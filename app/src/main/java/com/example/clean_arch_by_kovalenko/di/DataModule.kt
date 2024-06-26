package com.example.clean_arch_by_kovalenko.di

import com.example.clean_arch_by_kovalenko.data.repository.UserRepositoryImpl
import com.example.clean_arch_by_kovalenko.data.storage.UserStorage
import com.example.clean_arch_by_kovalenko.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.clean_arch_by_kovalenko.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}