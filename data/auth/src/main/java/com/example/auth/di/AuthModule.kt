package com.example.auth.di

import com.example.auth.repo.AuthRepo
import com.example.auth.repo.AuthRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {
    @Binds
    abstract fun provideAuthRepo(authRepoImpl: AuthRepoImpl): AuthRepo
}