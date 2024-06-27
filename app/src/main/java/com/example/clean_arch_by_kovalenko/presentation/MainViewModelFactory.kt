package com.example.clean_arch_by_kovalenko.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clean_arch_by_kovalenko.data.repository.UserRepositoryImpl
import com.example.clean_arch_by_kovalenko.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.clean_arch_by_kovalenko.domain.usecase.GetUserNameUseCase
import com.example.clean_arch_by_kovalenko.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase:SaveUserNameUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}