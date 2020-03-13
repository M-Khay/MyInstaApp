package com.yourself.myinstaapp

import android.app.Application
import com.yourself.myinstaapp.di.ComponentInjector

// appComponent lives in the Application class to share its lifecycle
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ComponentInjector.init()


    }

}