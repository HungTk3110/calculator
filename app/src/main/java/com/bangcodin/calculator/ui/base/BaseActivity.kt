package com.bangcodin.calculator.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.utils.LocaleHelper
import com.bangcodin.calculator.utils.SharePreference
import com.bangcodin.calculator.utils.setAppLocale
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        checkCurrentLanguage()

        super.onCreate(savedInstanceState)

        binding = setLayout()
        setContentView(binding.root)

    }

    private fun checkCurrentLanguage() {
        val currentLanguage =
            SharePreference.getStringPref(this, SharePreference.COUNTRY_CODE)
        if (currentLanguage.isNullOrEmpty()) {
            LocaleHelper().setLocale(this, "en")
        } else {
            LocaleHelper().setLocale(this, currentLanguage)
        }
    }
    override fun attachBaseContext(base: Context) {
        LocaleHelper().setLocale(base, LocaleHelper().getLanguage(base))
        super.attachBaseContext(LocaleHelper().onAttach(base))
    }

    protected abstract fun setLayout(): ViewBinding
    protected abstract fun initView(binding: ViewBinding)

    open fun openActivity(destinationClass: Class<*>, canBack: Boolean?) {
        val intent = Intent(this@BaseActivity, destinationClass)
        if (canBack != null && canBack == false) {
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
        if (canBack == false) {
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        initView(binding)
    }
}