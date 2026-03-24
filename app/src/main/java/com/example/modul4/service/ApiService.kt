package com.example.modul4.service

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import com.example.modul4.data.remote.LoginRequest
import com.example.modul4.data.remote.LoginResponse
import com.example.modul4.data.remote.UserListResponse

interface ApiService {
    @POST("api/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

    @GET("api/users")
    suspend fun getUsers(@Query("page") page: Int = 1): Response<UserListResponse>
}


