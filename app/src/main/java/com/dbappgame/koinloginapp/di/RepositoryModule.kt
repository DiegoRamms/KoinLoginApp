package com.dbappgame.koinloginapp.di

import com.dbappgame.koinloginapp.data.LoginDataSource
import com.dbappgame.koinloginapp.data.LoginRepositoryImp
import com.dbappgame.koinloginapp.domain.LoginRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val repositoryModule = module {
    singleOf(::LoginRepositoryImp){
        bind<LoginRepository>()
    }
    //single<LoginRepository> { LoginRepositoryImp(get()) }
}

