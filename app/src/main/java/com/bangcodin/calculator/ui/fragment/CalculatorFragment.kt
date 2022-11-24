/*
 * *
 *  * Created by Trinh Khac Hung on 8/30/22, 9:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/30/22, 9:00 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import android.view.View
import android.view.animation.AlphaAnimation
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentAdvancedCalculatorBinding
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.viewmodel.CalculatorViewModel
import javax.inject.Inject

class CalculatorFragment : BaseFragment() {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var binding: FragmentAdvancedCalculatorBinding
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun initView(viewBinding: ViewBinding) {
        this.binding = viewBinding as FragmentAdvancedCalculatorBinding

        binding.btnTrigonometry.setBackgroundResource(R.drawable.btn_status)

        initViewModel()
        binding.btnOperator.setOnClickListener {
            binding.btnOperator.setBackgroundResource(R.drawable.btn_status)
            binding.btnTrigonometry.setBackgroundResource(0)
            binding.cstLayoutKeyboard.cstLayoutTrigonometry.visibility = View.GONE
            binding.cstLayoutKeyboard.cstLayoutOperator.visibility = View.VISIBLE
        }
        binding.btnTrigonometry.setOnClickListener {
            binding.btnOperator.setBackgroundResource(0)
            binding.btnTrigonometry.setBackgroundResource(R.drawable.btn_status)
            binding.cstLayoutKeyboard.cstLayoutTrigonometry.visibility = View.VISIBLE
            binding.cstLayoutKeyboard.cstLayoutOperator.visibility = View.GONE
        }
        val alpha = AlphaAnimation(0f, 1f)
        alpha.duration = 300
        alpha.fillAfter = true
        binding.cstLayoutKeyboard.btn1.setOnClickListener {
            binding.cstLayoutKeyboard.btn1.startAnimation(alpha)
        }
    }

    private fun initViewModel() {
        calculatorViewModel =
            ViewModelProvider(this, viewmodelFactory)[CalculatorViewModel::class.java]
        binding.calculatorViewModell = calculatorViewModel
        binding.cstLayoutKeyboard.calculatorViewModel = calculatorViewModel
        binding.lifecycleOwner = this
    }

    override fun getLayout() = R.layout.fragment_advanced_calculator
}