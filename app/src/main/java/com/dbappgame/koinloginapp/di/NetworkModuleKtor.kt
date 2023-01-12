package com.dbappgame.koinloginapp.di

import android.util.Log
import com.dbappgame.koinloginapp.domain.LoginService
import com.dbappgame.koinloginapp.data.service.ktor.LoginServiceKtor
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private const val TIME_OUT = 60_000

val networkModuleKtor = module {
    singleOf(::provideHttpClient)
    single<LoginService> { LoginServiceKtor(get()) }
}


fun provideHttpClient() = HttpClient(Android) {
    install(JsonFeature){
        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    engine {
        connectTimeout = TIME_OUT
        socketTimeout = TIME_OUT
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("Logger Ktor =>", message)
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.v("HTTP status:", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
        contentType(ContentType.Application.Json)
    }
}


object ApiRoutes {
    private const val BASE_URL = "http://192.168.86.41:8080"
    const val LOGIN = "$BASE_URL/auth/login"
}

