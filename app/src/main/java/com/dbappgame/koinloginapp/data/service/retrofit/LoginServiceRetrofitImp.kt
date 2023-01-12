package com.dbappgame.koinloginapp.data.service.retrofit

import com.dbappgame.koinloginapp.data.model.LoginRequest
import com.dbappgame.koinloginapp.data.model.LoginResponse
import com.dbappgame.koinloginapp.domain.LoginService

class LoginServiceRetrofitImp(private val service: LoginServiceRetrofit): LoginService {
    override suspend fun doLogin(loginRequest: LoginRequest): LoginResponse {
        return service.doLogin(loginRequest)
    }
}