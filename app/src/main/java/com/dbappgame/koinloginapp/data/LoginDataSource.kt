package com.dbappgame.koinloginapp.data

import android.util.Log
import com.dbappgame.koinloginapp.data.model.LoggedInUser
import com.dbappgame.koinloginapp.data.model.LoginRequest
import com.dbappgame.koinloginapp.domain.LoginService
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
            Result.Success(LoggedInUser(response.data.uid,response.data.name,response.data.jwt))
        } catch (e: Throwable) {
            Log.e("ErrorNetwork",e.toString())
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}