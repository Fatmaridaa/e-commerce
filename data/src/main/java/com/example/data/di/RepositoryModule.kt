package com.example.data.di

import com.example.data.dataSource.AuthOnlineDataSourceImpl
import com.example.data.online.api.AuthService
import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.repository.AuthOnlineDataSource
import com.example.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAuthRepository(onlineDataSource: AuthOnlineDataSource) : AuthRepository{
        return AuthRepositoryImpl(onlineDataSource)
    }

    @Provides
    @Singleton
    fun provideAuthDataSource(authService: AuthService) : AuthOnlineDataSource{
        return AuthOnlineDataSourceImpl(authService = authService)

    }
}