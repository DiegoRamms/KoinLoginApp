package com.dbappgame.koinloginapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.lifecycle.viewModelScope
import com.dbappgame.koinloginapp.data.LoginRepositoryImp
import com.dbappgame.koinloginapp.data.Result

import com.dbappgame.koinloginapp.R
import com.dbappgame.koinloginapp.domain.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = Channel<LoginResult>()
    val loginResult = _loginResult.receiveAsFlow()

    fun login(email: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val result = loginRepository.login(email, password)

            if (result is Result.Success) {
                _loginResult.send(
                    LoginResult(success = LoggedInUserView(displayName = result.data.displayName, result.data.jwt)))
            } else {
                _loginResult.send(LoginResult(error = R.string.login_failed))
            }
        }

    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}