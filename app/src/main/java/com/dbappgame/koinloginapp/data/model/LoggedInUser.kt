package com.dbappgame.koinloginapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */

data class LoggedInUser(
    val userId: String,
    val displayName: String,
    val jwt: String
)