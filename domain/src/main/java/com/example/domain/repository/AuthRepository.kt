package com.example.domain.repository

import com.example.domain.entities.AuthResponseEntity
import com.example.domain.entities.request.LoginRequestEntity
import com.example.domain.entities.request.RegisterRequestEntity

interface AuthRepository {

    suspend fun login(requestEntity: LoginRequestEntity):AuthResponseEntity
    suspend fun register(requestEntity: RegisterRequestEntity) : AuthResponseEntity
}



interface AuthOnlineDataSource{
    suspend fun login(requestEntity: LoginRequestEntity): AuthResponseEntity
    suspend fun register(requestEntity: RegisterRequestEntity) : AuthResponseEntity
}