package com.example.gcmdemo

import android.app.Application
import com.example.gcmdemo.util.SharedPreferencesUtil


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        lateinit var application: Application
            private set

        var myUserID: String = ""
            get() {
                field = SharedPreferencesUtil.getUserID(application.applicationContext).orEmpty()
                return field
            }
            private set
    }
}
