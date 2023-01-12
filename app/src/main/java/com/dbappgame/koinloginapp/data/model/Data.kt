package com.dbappgame.koinloginapp.data.model


import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class Data(
    @SerializedName("code")
    val code: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("jwt")
    val jwt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("uid")
    val uid: String
)