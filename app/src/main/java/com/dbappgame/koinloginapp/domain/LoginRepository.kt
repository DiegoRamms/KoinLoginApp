package com.dbappgame.koinloginapp.domain

import com.dbappgame.koinloginapp.data.Result
import com.dbappgame.koinloginapp.data.model.LoggedInUser

interface LoginRepository {
    suspend fun login(email: String, password: String): Result<LoggedInUser>
    fun setLoggedInUser(loggedInUser: LoggedInUser)
}