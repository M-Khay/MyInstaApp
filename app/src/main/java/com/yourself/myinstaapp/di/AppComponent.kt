package com.yourself.myinstaapp.di

import com.yourself.myinstaapp.ui.MainActivity
import com.yourself.myinstaapp.ui.UserPostListViewModel
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class, AppModule::class,
        NetworkModule::class,UserPostListRepositoryModule::class)
)

interface AppComponent {

    fun inject(userPostListViewModel: UserPostListViewModel)
}

