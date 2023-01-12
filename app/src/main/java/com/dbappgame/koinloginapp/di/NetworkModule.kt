package com.dbappgame.koinloginapp.di

import com.dbappgame.koinloginapp.data.service.LoginService
import com.google.gson.Gson
import io.ktor.client.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    factory { provideHttpClient() }
    single { provideRetrofit(get()) }
    single { provideLoginService(get()) }
}

fun provideHttpClient(): OkHttpClient {
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

fun provideLoginService(retrofit: Retrofit): LoginService{
    return retrofit.create(LoginService::class.java)
}