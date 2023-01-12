package com.dbappgame.koinloginapp.ui.login

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * User details post authentication that is exposed to the UI
 */

@Parcelize
data class LoggedInUserView(
    val displayName: String,
    val jwt: String
    //... other data fields that may be accessible to the UI
): Parcelable