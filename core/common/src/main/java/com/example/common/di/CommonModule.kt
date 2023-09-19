package com.example.common.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.appwrite.Client
import io.appwrite.services.Account
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Provides
    @Singleton
    fun provideAppwriteClient(@ApplicationContext context: Context) = Client(context)
        .setEndpoint("https://cloud.appwrite.io/v1")
        .setProject("64f95cfebf8d4953f7a6")

    @Provides
    @Singleton
    fun provideAppwriteAccountService(client: Client) = Account(client)
}