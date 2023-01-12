package com.dbappgame.koinloginapp.data

import com.dbappgame.koinloginapp.data.model.LoggedInUser
import com.dbappgame.koinloginapp.data.model.LoginRequest
import com.dbappgame.koinloginapp.data.service.LoginService
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(private val service: LoginService) {

    suspend fun login(email: String, password: String): Result<LoggedInUser> {
        return try {
            // TODO: handle loggedInUser authentication
            //val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            val loginRequest = LoginRequest(appType = "MoneyLeneder", email, password)
            val response =service.doLogin(loginRequest)
            Result.Success(LoggedInUser(response.dataInfo.uid,response.dataInfo.name,response.dataInfo.jwt))
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}