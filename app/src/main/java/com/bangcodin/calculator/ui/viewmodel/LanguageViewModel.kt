/*
 * *
 *  * Created by Trinh Khac Hung on 11/17/22, 3:36 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/17/22, 3:36 PM
 *
 */

package com.bangcodin.calculator.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bangcodin.calculator.utils.SharePreference

class LanguageViewModel(application: Application) : AndroidViewModel(application) {

    val countryCode = MutableLiveData<String?>()
    val currentLanguage = MutableLiveData<String?>()

    init {
        val currentLang =
            SharePreference.getStringPref(application, SharePreference.CURRENT_LANGUAGE)

        if (currentLang.isNullOrEmpty()) {
            currentLanguage.value = "English"
        } else {
            currentLanguage.value = currentLang
        }

    }
}