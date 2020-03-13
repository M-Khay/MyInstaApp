package com.yourself.myinstaapp.repository

import com.yourself.myinstaapp.model.UserPostResponse
import com.yourself.myinstaapp.repository.network.UserPostListApiService

class UserPostListRepositoryImpl(private val userPostListApiService: UserPostListApiService) : UserPostListRepository{

    val API_KEY  = "8630898-e092bf16cb1dd9ff6a483dabf"

    override suspend fun getUserPostList(imageType: String, perPage: Int,safeSearch: Boolean)=
        userPostListApiService.getUserPostList(API_KEY,imageType,perPage,safeSearch)

}