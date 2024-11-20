package com.example.data.online.api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiManager {


    @Provides
    @Singleton
    fun provideGsonConverterFactory() : GsonConverterFactory{
        return GsonConverterFactory.create()
    }


    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() : Interceptor{
        val loggingInterceptor = HttpLoggingInterceptor{ message ->
            Log.e("Api" , message ,)
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor

    }


    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: Interceptor) : OkHttpClient  {
        return OkHttpClient.Builder()

            .addInterceptor(httpLoggingInterceptor)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofitInstance(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
        ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl( "https://ecommerce.routemisr.com/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit):AuthService{
        return retrofit.create(AuthService::class.java)

    }
}