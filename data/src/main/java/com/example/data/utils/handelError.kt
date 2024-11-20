package com.example.data.utils

import android.util.Log
import com.example.data.R
import com.example.data.models.auth.AuthResponseModel
import com.google.gson.Gson
import okio.IOException
import retrofit2.Response
import java.net.UnknownHostException

fun handelError(throwable: Throwable):Exception{

    return when(throwable){
        is UnknownHostException, is IOException -> {
            Log.e("TAG" , "handelError : ${throwable.message}")
            R.string.check_your_connection
            Exception( throwable)
        }else -> {
            Log.e("TAG" , "handelError : ${throwable.message}")
            Log.e("TAG" , "handelError : Throwable object : $throwable")
            Exception( throwable)
        }
    }
}

fun <T> handelError(response: Response<T>) : Exception {
    val sourceResponse = response.errorBody()?.string()?.fromJson(AuthResponseModel::class.java)
    Log.e("TAG" , "handelError : message => ${sourceResponse?.message}")
    return Exception(sourceResponse?.message)
}

fun <T> String.fromJson(clazz: Class<T>) : T{
    val gson = Gson()
    return gson.fromJson(this, clazz)
}