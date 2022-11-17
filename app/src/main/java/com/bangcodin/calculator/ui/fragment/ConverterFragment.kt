/*
 * *
 *  * Created by Nguyen Van Thai on 8/25/22, 3:21 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/25/22, 3:18 PM
 *
 */

package com.bangcodin.calculator.ui.fragment
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentConverterBinding
import com.bangcodin.calculator.ui.base.BaseFragment


class ConverterFragment : BaseFragment() {
    private lateinit var binding: FragmentConverterBinding
    override fun initView(viewBinding: ViewBinding) {
        binding = viewBinding as FragmentConverterBinding
        setOnClickItem()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_converter
    }



    private fun setOnClickItem(){
            val bottomSheetFragment = BottomSheetFragment()
            binding.toolbar.setOnClickListener{
                bottomSheetFragment.show(parentFragmentManager, "BottomSheetDialog")
            }
    }
}