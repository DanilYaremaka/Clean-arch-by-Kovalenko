package com.example.clean_arch_by_kovalenko.di

import com.example.clean_arch_by_kovalenko.domain.repository.UserRepository
import com.example.clean_arch_by_kovalenko.domain.usecase.GetUserNameUseCase
import com.example.clean_arch_by_kovalenko.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository)
    }
    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository)
    }
}