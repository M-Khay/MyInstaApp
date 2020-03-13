package com.yourself.myinstaapp.di

import com.yourself.myinstaapp.repository.network.UserPostListApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {
    val BASE_URL = "https://pixabay.com/"

    @Provides
    fun provideUserPostListApiService(retrofit: Retrofit) =
        retrofit.create(UserPostListApiService::class.java)
    //You can use the @Provides annotation in Dagger modules to tell Dagger how to provide classes
    //that your project doesn't own (e.g. an instance of Retrofit).

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor (logging)
//            .addInterceptor { chain ->
//                val request =
//                    chain.request().newBuilder().addHeader("x-rapidapi-key", API_KEY).build()
//                chain.proceed(request)
//            }
            .build()
    }
}