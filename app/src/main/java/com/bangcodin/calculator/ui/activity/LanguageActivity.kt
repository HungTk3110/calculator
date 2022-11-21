/*
 * *
 *  * Created by Trinh Khac Hung on 22:42, 24/08/2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 22:42, 24/08/2022
 *
 */

package com.bangcodin.calculator.ui.activity

import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.ActivityLanguageBinding
import com.bangcodin.calculator.models.Language
import com.bangcodin.calculator.ui.adapter.Callback
import com.bangcodin.calculator.ui.adapter.LanguageAdapter
import com.bangcodin.calculator.ui.base.BaseActivity
import com.bangcodin.calculator.ui.viewmodel.LanguageViewModel
import com.bangcodin.calculator.utils.LocaleHelper
import com.bangcodin.calculator.utils.SharePreference
import com.bangcodin.calculator.utils.setAppLocale
import com.shashank.sony.fancytoastlib.FancyToast
import java.util.Locale

class LanguageActivity : BaseActivity(), Callback {
    private lateinit var binding: ActivityLanguageBinding
    private lateinit var languageViewModel: LanguageViewModel
    override fun setLayout(): ViewBinding =
        ActivityLanguageBinding.inflate(layoutInflater) as ViewBinding

    override fun initView(binding: ViewBinding) {
        this.binding = binding as ActivityLanguageBinding

        languageViewModel = ViewModelProvider(this)[LanguageViewModel::class.java]
        LanguageAdapter.callback = this
        setRCVLanguage()
        binding.btnOk.setOnClickListener {
            setClickBtnOk()
        }
    }

    private fun setClickBtnOk() {
        LocaleHelper().setLocale(this, language = languageViewModel.countryCode.value.toString())
        SharePreference.setStringPref(application, SharePreference.COUNTRY_CODE,languageViewModel.countryCode.value.toString())
        recreate()
        openActivity(MainActivity::class.java,false)
    }

    private fun setRCVLanguage() {
        val adapter = LanguageAdapter(languageViewModel, this)
        binding.rcvLanguage.adapter = adapter
        val listLanguage = ArrayList<Language>()
        listLanguage.add(Language("en", "English", R.drawable.english))
        listLanguage.add(Language("kr", "Arab", R.drawable.kr))
        listLanguage.add(Language("vi", "Vietnam", R.drawable.ic_vietnam))
        listLanguage.add(Language("jp", "Japan", R.drawable.jp))
        adapter.submitList(listLanguage)
    }

    override fun onLanguageChange(language: Language) {
        languageViewModel.currentLanguage.value = language.label
        languageViewModel.countryCode.value = language.countryCode
//        FancyToast.makeText(this, languageViewModel.countryCode.value.toString(),FancyToast.LENGTH_SHORT, FancyToast.WARNING, false).show()
    }
}