package com.dbappgame.koinloginapp.di

import com.dbappgame.koinloginapp.data.service.retrofit.LoginServiceRetrofit
import com.dbappgame.koinloginapp.data.service.retrofit.LoginServiceRetrofitImp
import com.dbappgame.koinloginapp.domain.LoginService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModuleRetrofit = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideLoginServiceRetrofit(get()) }
    singleOf(::LoginServiceRetrofitImp){
        bind<LoginService>()
    }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("http://192.168.86.41:8080")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideLoginServiceRetrofit(retrofit: Retrofit): LoginServiceRetrofit {
    return retrofit.create(LoginServiceRetrofit::class.java)
}

