/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 12:14 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 12:14 PM
 *
 */

package com.bangcodin.calculator.ui.fragment


import android.content.Intent
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentSettingBinding
import com.bangcodin.calculator.ui.activity.LanguageActivity
import com.bangcodin.calculator.ui.base.BaseFragment

class   SettingFragment : BaseFragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun initView(viewBinding: ViewBinding) {
        binding = viewBinding as FragmentSettingBinding
        setOnClickItem()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_setting
    }


    private fun setOnClickItem() {
        val alpha = AlphaAnimation(0f, 1f)
        alpha.duration = 400
        alpha.fillAfter = true
        val share = ShareFragment()
        val term = TermFragment()
        binding.iclListSetting.itemEnglish.setOnClickListener {
            binding.iclListSetting.itemEnglish.startAnimation(alpha)
            openActivity(LanguageActivity::class.java)
        }
        binding.iclListSetting.itemShare.setOnClickListener {
            binding.iclListSetting.itemShare.startAnimation(alpha)
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Hey Check out this Great app:"
            )
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
        binding.iclListSetting.itemRate.setOnClickListener {
            binding.iclListSetting.itemRate.startAnimation(alpha)
            Toast.makeText(context, "Tính năng đang hoàn thiện!", Toast.LENGTH_SHORT).show()
        }
        binding.iclListSetting.itemTerm.setOnClickListener {
            binding.iclListSetting.itemTerm.startAnimation(alpha)
            pushScreenAsNormalWithT6(term, TermFragment::class.java.name)
        }


    }
}