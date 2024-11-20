package com.example.data.dataSource

import com.example.data.mappers.toEntity
import com.example.data.mappers.toModel
import com.example.data.online.api.AuthService
import com.example.data.request.LoginRequestModel
import com.example.data.utils.handelError
import com.example.domain.entities.AuthResponseEntity
import com.example.domain.entities.request.LoginRequestEntity
import com.example.domain.entities.request.RegisterRequestEntity
import com.example.domain.repository.AuthOnlineDataSource

class AuthOnlineDataSourceImpl( private val authService: AuthService) : AuthOnlineDataSource {
    override suspend fun login(requestEntity: LoginRequestEntity): AuthResponseEntity {

        try {
            val response = authService.login(requestEntity.toModel())
            if (response.code() in 200..300){
                return response.body()?.toEntity() !!
            }
               throw handelError(response)

        }catch (e:Exception){
            throw handelError(e)

        }

    }

    override suspend fun register(requestEntity: RegisterRequestEntity): AuthResponseEntity {


        try {
            val response = authService.register(requestEntity.toModel())
            if (response.code() in 200..300){
                return response.body()?.toEntity() !!
            }
                throw handelError(response)

        }catch (e:Exception){
            throw handelError(e)
        }
    }
}