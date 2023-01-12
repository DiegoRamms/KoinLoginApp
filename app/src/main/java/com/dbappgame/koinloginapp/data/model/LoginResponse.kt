package com.dbappgame.koinloginapp.data.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val dataInfo: Data,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("status")
    val status: Boolean
)