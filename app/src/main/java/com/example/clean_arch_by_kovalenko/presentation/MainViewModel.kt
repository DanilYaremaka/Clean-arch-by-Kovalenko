package com.example.clean_arch_by_kovalenko.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clean_arch_by_kovalenko.data.repository.UserRepositoryImpl
import com.example.clean_arch_by_kovalenko.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.clean_arch_by_kovalenko.domain.entity.SaveUserNameParam
import com.example.clean_arch_by_kovalenko.domain.entity.UserName
import com.example.clean_arch_by_kovalenko.domain.usecase.GetUserNameUseCase
import com.example.clean_arch_by_kovalenko.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {


    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String>
        get() = _resultLive

    fun save(text: String) {
        val resultData = saveUserNameUseCase(SaveUserNameParam(text))
        _resultLive.value = "Save result = $resultData"
    }

    fun load() {
        val userName: UserName =
            getUserNameUseCase()
        _resultLive.value = "${userName.lastName} ${userName.firstName}"
    }

}