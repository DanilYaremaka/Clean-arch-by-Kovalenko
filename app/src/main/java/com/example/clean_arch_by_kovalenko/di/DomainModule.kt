package com.example.clean_arch_by_kovalenko.di

import com.example.clean_arch_by_kovalenko.domain.usecase.GetUserNameUseCase
import com.example.clean_arch_by_kovalenko.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModel = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(get())
    }

}