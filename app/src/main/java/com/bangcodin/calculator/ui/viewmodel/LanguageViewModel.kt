/*
 * *
 *  * Created by Trinh Khac Hung on 11/17/22, 3:36 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/17/22, 3:36 PM
 *
 */

package com.bangcodin.calculator.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangcodin.calculator.utils.SharePreference
import javax.inject.Inject

class LanguageViewModel @Inject constructor(application: Application) : ViewModel() {

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