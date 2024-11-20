package com.example.data.online.api

import com.example.data.models.auth.AuthResponseModel
import com.example.data.request.LoginRequestModel
import com.example.data.request.RegisterRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/signup")
    suspend fun register(@Body request : RegisterRequestModel):Response<AuthResponseModel>

    @POST("auth/signin")
    suspend fun login(@Body request : LoginRequestModel) : Response<AuthResponseModel>
}