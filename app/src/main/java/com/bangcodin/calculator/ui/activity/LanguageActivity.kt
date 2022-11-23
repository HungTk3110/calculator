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
import com.bangcodin.calculator.data.models.Language
import com.bangcodin.calculator.databinding.ActivityLanguageBinding
import com.bangcodin.calculator.ui.adapter.Callback
import com.bangcodin.calculator.ui.adapter.LanguageAdapter
import com.bangcodin.calculator.ui.base.BaseActivity
import com.bangcodin.calculator.ui.viewmodel.LanguageViewModel
import com.bangcodin.calculator.utils.LocaleHelper
import com.bangcodin.calculator.utils.SharePreference
import javax.inject.Inject

class LanguageActivity : BaseActivity(), Callback {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityLanguageBinding
    private lateinit var languageViewModel: LanguageViewModel
    override fun setLayout(): ViewBinding =
        ActivityLanguageBinding.inflate(layoutInflater)

    override fun initView(binding: ViewBinding) {
        this.binding = binding as ActivityLanguageBinding

        initViewModel()
        LanguageAdapter.callback = this
        setRCVLanguage()
        binding.btnOk.setOnClickListener {
            setClickBtnOk()
        }
    }

    private fun initViewModel() {
        languageViewModel = ViewModelProvider(this, viewmodelFactory)[LanguageViewModel::class.java]
    }

    private fun setClickBtnOk() {
        LocaleHelper().setLocale(this, language = languageViewModel.countryCode.value.toString())
        SharePreference.setStringPref(
            application,
            SharePreference.COUNTRY_CODE,
            languageViewModel.countryCode.value.toString()
        )
        recreate()
        openActivity(MainActivity::class.java, false)
    }

    private fun setRCVLanguage() {
        val adapter = LanguageAdapter(languageViewModel, this)
        binding.rcvLanguage.adapter = adapter
        val listLanguage = ArrayList<Language>()
        listLanguage.add(Language("en", "English", R.drawable.english, false))
        listLanguage.add(Language("kr", "Korean", R.drawable.kr, false))
        listLanguage.add(Language("vi", "Vietnam", R.drawable.ic_vietnam, false))
        listLanguage.add(Language("jp", "Japan", R.drawable.jp, false))
        adapter.submitList(listLanguage)
    }

    override fun onLanguageChange(language: Language) {
        languageViewModel.currentLanguage.value = language.label
        SharePreference.setStringPref(application, SharePreference.CURRENT_LANGUAGE, language.label)
        languageViewModel.countryCode.value = language.countryCode
        language.check = true
//        FancyToast.makeText(this, languageViewModel.countryCode.value.toString(),FancyToast.LENGTH_SHORT, FancyToast.WARNING, false).show()
    }
}