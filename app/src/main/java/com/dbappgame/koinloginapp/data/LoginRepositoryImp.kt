package com.dbappgame.koinloginapp.data

import com.dbappgame.koinloginapp.data.model.LoggedInUser
import com.dbappgame.koinloginapp.domain.LoginRepository

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepositoryImp(private val dataSource: LoginDataSource): LoginRepository {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    override suspend fun login(email: String, password: String): Result<LoggedInUser> {
        // handle login
        val result = dataSource.login(email, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    override fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }


}