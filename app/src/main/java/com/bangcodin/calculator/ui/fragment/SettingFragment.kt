/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 12:14 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 12:14 PM
 *
 */

package com.bangcodin.calculator.ui.fragment


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
        val share = ShareFragment()
        val term = TermFragment()
        binding.iclListSetting.itemEnglish.setOnClickListener {
            openActivity(LanguageActivity::class.java)
        }
        binding.iclListSetting.itemShare.setOnClickListener {
            share.show(parentFragmentManager, "BottomSheetShare")
        }
        binding.iclListSetting.itemRate.setOnClickListener {
            Toast.makeText(context, "Tính năng đang hoàn thiện!", Toast.LENGTH_SHORT).show()
        }
        binding.iclListSetting.itemTerm.setOnClickListener {
            pushScreenAsNormalWithT6(term, TermFragment::class.java.name)
        }


    }
}