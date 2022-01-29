package com.dicoding.tourismapp

import android.app.Application
import com.dicoding.tourismapp.core.utils.LineNumberTimber
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(LineNumberTimber())
        }
    }
}