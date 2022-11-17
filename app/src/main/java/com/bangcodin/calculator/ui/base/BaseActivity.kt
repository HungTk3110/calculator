package com.bangcodin.calculator.ui.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.utils.SharePreference
import com.bangcodin.calculator.utils.setAppLocale


abstract class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        checkCurrentLanguage()

        super.onCreate(savedInstanceState)

        binding = setLayout()
        setContentView(binding.root)

    }

    private fun checkCurrentLanguage() {
        val currentLanguage =
            SharePreference.getStringPref(application, SharePreference.CURRENT_LANGUAGE)
        if (currentLanguage.isNullOrEmpty()) {
            setAppLocale(this, "en")
        } else {
            setAppLocale(this, currentLanguage)
        }
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