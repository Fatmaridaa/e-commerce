package com.example.domain.useCases

import com.example.domain.entities.AuthResponseEntity
import com.example.domain.entities.request.RegisterRequestEntity
import com.example.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor (private val repository: AuthRepository) {

    suspend operator fun invoke(registerRequestEntity: RegisterRequestEntity) : AuthResponseEntity{
        return repository.register(registerRequestEntity)

    }
}