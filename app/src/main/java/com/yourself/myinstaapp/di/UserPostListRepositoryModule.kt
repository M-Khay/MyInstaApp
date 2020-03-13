package com.yourself.myinstaapp.di

import com.yourself.myinstaapp.repository.UserPostListRepository
import com.yourself.myinstaapp.repository.UserPostListRepositoryImpl
import com.yourself.myinstaapp.repository.network.UserPostListApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserPostListRepositoryModule {

    @Singleton
    @Provides
    fun provideUserPostListRepository(userPostListApiService: UserPostListApiService):
            UserPostListRepository= UserPostListRepositoryImpl(userPostListApiService)
}