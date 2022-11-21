package com.bangcodin.calculator.ui.base


import android.app.Application
import com.bangcodin.calculator.utils.LocaleHelper
import com.bangcodin.calculator.utils.setAppLocale

open class BaseApplication : Application() {

    companion object {
        lateinit var app: BaseApplication

        fun getInstance(): BaseApplication {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        LocaleHelper().setLocale(this, "en")
    }
}