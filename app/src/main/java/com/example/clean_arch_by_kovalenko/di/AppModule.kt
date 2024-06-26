package com.example.clean_arch_by_kovalenko.di

import com.example.clean_arch_by_kovalenko.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(get(), get())
    }
}