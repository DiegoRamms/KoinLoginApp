package com.dbappgame.koinloginapp.data.model


import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class LoginRequest(

    val appType: String,

    val email: String,

    val password: String
)