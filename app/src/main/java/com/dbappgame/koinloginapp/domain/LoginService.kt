package com.dbappgame.koinloginapp.domain

import com.dbappgame.koinloginapp.data.model.LoginRequest
import com.dbappgame.koinloginapp.data.model.LoginResponse

interface LoginService {
    suspend fun doLogin(loginRequest: LoginRequest): LoginResponse
}