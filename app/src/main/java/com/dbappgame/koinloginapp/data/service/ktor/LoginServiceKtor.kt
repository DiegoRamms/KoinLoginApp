package com.dbappgame.koinloginapp.data.service.ktor

import com.dbappgame.koinloginapp.data.model.LoginRequest
import com.dbappgame.koinloginapp.data.model.LoginResponse
import com.dbappgame.koinloginapp.di.ApiRoutes
import com.dbappgame.koinloginapp.domain.LoginService
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class LoginServiceKtor(private val client: HttpClient) : LoginService {
    override suspend fun doLogin(loginRequest: LoginRequest): LoginResponse =
        client.post(ApiRoutes.LOGIN){
            body = loginRequest
        }
}