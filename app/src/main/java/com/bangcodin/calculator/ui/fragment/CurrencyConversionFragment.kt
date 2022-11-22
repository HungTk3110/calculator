/*
 * *
 *  * Created by Nguyen Van Thai on 8/30/22, 2:17 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/30/22, 2:17 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentCurrencyConversionBinding
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.viewmodel.CurrencyConverterViewModel
import javax.inject.Inject

class CurrencyConversionFragment : BaseFragment(), BottomSheetNational.OptionConverter {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var currencyConverterViewModel: CurrencyConverterViewModel
    private val bottomSheetNational = BottomSheetNational()
    private lateinit var binding: FragmentCurrencyConversionBinding
    override fun initView(viewBinding: ViewBinding) {

        binding = viewBinding as FragmentCurrencyConversionBinding
        bottomSheetNational.optionConverter = this
        setOnClickItem()
        initViewModel()
        binding.tvNationalNeedConvert.setOnClickListener {
            bottomSheetNational.show(parentFragmentManager, "")
            currencyConverterViewModel.isCheckClick = false
        }

        binding.tvNationalConverted.setOnClickListener {
            bottomSheetNational.show(parentFragmentManager, "")
            currencyConverterViewModel.isCheckClick = true
        }
    }

     private fun initViewModel(){
        currencyConverterViewModel =
            ViewModelProvider(this, viewmodelFactory)[CurrencyConverterViewModel::class.java]
        binding.currency = currencyConverterViewModel
        binding.lifecycleOwner = this
    }

    override fun getLayout(): Int {
        return R.layout.fragment_currency_conversion
    }


    private fun setOnClickItem() {
        val bottomSheet = BottomSheetFragment()
        binding.toolbar.setOnClickListener {
            bottomSheet.show(parentFragmentManager, "BottomSheet")
        }
    }

    override fun selectedOptionConverter(position: Int) {
        currencyConverterViewModel.handleSelectedNationalConverter(position)
    }

    override fun selectedOptionConverted(position: Int) {
        currencyConverterViewModel.handleSelectedNationalConverted(position)
    }

}