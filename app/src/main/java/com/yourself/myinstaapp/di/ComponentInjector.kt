package com.yourself.myinstaapp.di

class ComponentInjector {
    companion object {
        lateinit var component: AppComponent
        fun init() {
            component = DaggerAppComponent.builder()
                .userPostListRepositoryModule(UserPostListRepositoryModule())
                .build()
        }

    }
}