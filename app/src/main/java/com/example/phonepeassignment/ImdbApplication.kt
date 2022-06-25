package com.example.phonepeassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ImdbApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}