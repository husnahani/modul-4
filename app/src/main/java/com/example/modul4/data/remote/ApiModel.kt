package com.example.modul4.data.remote

import com.google.gson.annotations.SerializedName

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String)

data class User(
    val id: Int,
    val email: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    val avatar: String
)
data class UserListResponse(
    val page: Int,
    val data: List<User>
)