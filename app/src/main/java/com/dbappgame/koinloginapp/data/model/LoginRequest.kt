package com.dbappgame.koinloginapp.data.model


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("appType")
    val appType: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)