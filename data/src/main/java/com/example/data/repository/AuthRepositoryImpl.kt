package com.example.data.repository

import com.example.domain.entities.AuthResponseEntity
import com.example.domain.entities.request.LoginRequestEntity
import com.example.domain.entities.request.RegisterRequestEntity
import com.example.domain.repository.AuthOnlineDataSource
import com.example.domain.repository.AuthRepository

class AuthRepositoryImpl (private val onlineDataSource: AuthOnlineDataSource): AuthRepository {
    override suspend fun login(requestEntity: LoginRequestEntity): AuthResponseEntity {
        return onlineDataSource.login(requestEntity)
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): AuthResponseEntity {
       return onlineDataSource.register(requestEntity)
    }
}