package com.yourself.myinstaapp.repository.network

import com.yourself.myinstaapp.model.UserPostResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserPostListApiService{
    @GET("api/")
    suspend fun getUserPostList(@Query("key")key : String,@Query("image_type")imageType: String,@Query("per_page")perPage: Int,@Query("safesearch")safeSearch:Boolean):UserPostResponse
}