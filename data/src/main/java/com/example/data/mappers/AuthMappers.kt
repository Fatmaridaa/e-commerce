package com.example.data.mappers

import com.example.data.models.auth.AuthResponseModel
import com.example.data.models.auth.UserModel
import com.example.data.request.LoginRequestModel
import com.example.data.request.RegisterRequestModel
import com.example.domain.entities.AuthResponseEntity
import com.example.domain.entities.UserEntity
import com.example.domain.entities.request.LoginRequestEntity
import com.example.domain.entities.request.RegisterRequestEntity

fun AuthResponseModel.toEntity() : AuthResponseEntity {

    return AuthResponseEntity(message, userEntity = userModel?.toEntity(),statusMsg, token)

}

fun UserModel.toEntity() : UserEntity {
    return UserEntity(role, name, email)
}


fun LoginRequestEntity.toModel(): LoginRequestModel{

    return LoginRequestModel(password, email)
}


fun RegisterRequestEntity.toModel() : RegisterRequestModel{
    return RegisterRequestModel(password, phone, rePassword, name, email)
}