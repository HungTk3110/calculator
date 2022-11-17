/*
 * *
 *  * Created by Trinh Khac Hung on 8/30/22, 9:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/30/22, 9:00 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentAdvancedCalculatorBinding
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.database.HistoryDatabase
import com.bangcodin.calculator.ui.viewmodel.CalculatorViewModel

class CalculatorFragment : BaseFragment() {

    private lateinit var historyapp: HistoryDatabase
    private lateinit var binding: FragmentAdvancedCalculatorBinding
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun initView(viewBinding: ViewBinding) {
        this.binding = viewBinding as FragmentAdvancedCalculatorBinding
        historyapp = HistoryDatabase.getDatabase(requireContext())

        binding.btnOperator.setOnClickListener {
            binding.cstLayoutKeyboard.cstLayoutTrigonometry.visibility = View.GONE
            binding.cstLayoutKeyboard.cstLayoutOperator.visibility = View.VISIBLE
        }
        binding.btnTrigonometry.setOnClickListener {
            binding.cstLayoutKeyboard.cstLayoutTrigonometry.visibility = View.VISIBLE
            binding.cstLayoutKeyboard.cstLayoutOperator.visibility = View.GONE
        }

        calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]
        binding.calculatorViewModell = calculatorViewModel
        binding.cstLayoutKeyboard.calculatorViewModel = calculatorViewModel
        binding.lifecycleOwner = this
    }

    override fun getLayout() = R.layout.fragment_advanced_calculator
}