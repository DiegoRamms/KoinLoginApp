package com.dbappgame.koinloginapp.data.service.retrofit

import com.dbappgame.koinloginapp.data.model.LoginRequest
import com.dbappgame.koinloginapp.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginServiceRetrofit {

    @POST("auth/login")
    suspend fun doLogin(@Body loginRequest: LoginRequest): LoginResponse

}