package com.yourself.myinstaapp.repository

import com.yourself.myinstaapp.model.UserPostResponse

interface UserPostListRepository {
    suspend fun getUserPostList(imageType:String,perPage  : Int,safeSearch : Boolean): UserPostResponse
}