package com.example.domain.entities

data class AuthResponseEntity(
	val message: String? = null,
	val userEntity: UserEntity? = null,
	val statusMsg : String? = null,
	val token: String? = null
)

data class UserEntity(
	val role: String? = null,
	val name: String? = null,
	val email: String? = null
)

