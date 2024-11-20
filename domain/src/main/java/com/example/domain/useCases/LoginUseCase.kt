package com.example.domain.useCases

import com.example.domain.entities.AuthResponseEntity
import com.example.domain.entities.request.LoginRequestEntity
import com.example.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor (private val repository: AuthRepository){

    suspend operator fun invoke(loginRequestEntity: LoginRequestEntity):AuthResponseEntity{

        return repository.login(loginRequestEntity)
    }
}