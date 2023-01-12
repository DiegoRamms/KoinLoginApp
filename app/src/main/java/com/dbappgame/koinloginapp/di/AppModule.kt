package com.dbappgame.koinloginapp.di

import com.dbappgame.koinloginapp.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {
    viewModelOf(::LoginViewModel)
    //viewModel { LoginViewModel(get()) }
}