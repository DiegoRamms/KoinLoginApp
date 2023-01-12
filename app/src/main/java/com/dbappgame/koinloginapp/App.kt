package com.dbappgame.koinloginapp

import android.app.Application
import com.dbappgame.koinloginapp.di.appModule
import com.dbappgame.koinloginapp.di.dataSourceModule
import com.dbappgame.koinloginapp.di.networkModule
import com.dbappgame.koinloginapp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(appModule, repositoryModule, dataSourceModule, networkModule)
        }

    }

}