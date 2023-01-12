package com.dbappgame.koinloginapp.di

import com.dbappgame.koinloginapp.data.LoginDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { LoginDataSource(get()) }

}