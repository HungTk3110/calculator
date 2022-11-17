package com.bangcodin.calculator.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

class Helper {
    companion object{
        const val ENGLISH = "en"
        const val VIET_NAM = "vi"
    }
}
@Suppress("DEPRECATION")
fun setAppLocale(context: Context, language: String) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = context.resources.configuration
    config.setLocale(locale)
    context.createConfigurationContext(config)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
    context.createConfigurationContext(config)
}
