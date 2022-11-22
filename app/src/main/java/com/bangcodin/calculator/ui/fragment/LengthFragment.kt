package com.bangcodin.calculator.ui.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentLengthConversionBinding
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.viewmodel.LengthConverterViewModel
import javax.inject.Inject

class LengthFragment : BaseFragment(), BottomSheetLengthFragment.OptionConverterKm {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var lengthConverterViewModel: LengthConverterViewModel
    private lateinit var binding: FragmentLengthConversionBinding
    private val bottomSheetLength = BottomSheetLengthFragment()
    override fun initView(viewBinding: ViewBinding) {

        bottomSheetLength.optionConverterKm = this
        binding = viewBinding as FragmentLengthConversionBinding
        setOnClick()
        initViewModel()

    }

    override fun getLayout(): Int {
        return R.layout.fragment_length_conversion
    }

    fun initViewModel() {
        lengthConverterViewModel =
            ViewModelProvider(this, viewmodelFactory)[LengthConverterViewModel::class.java]
        binding.length = lengthConverterViewModel
        binding.lifecycleOwner = this
    }

    private fun setOnClick() {
        val bottomSheet = BottomSheetFragment()
        binding.toolbar.setOnClickListener {
            bottomSheet.show(parentFragmentManager, "BottomSheet")
        }
        binding.lengthConverted.setOnClickListener {
            bottomSheetLength.show(parentFragmentManager, "BottomSheetLength")
            lengthConverterViewModel.isCheckClick = false
        }
        binding.lengthConverter.setOnClickListener {
            bottomSheetLength.show(parentFragmentManager, "BottomSheetLength")
            lengthConverterViewModel.isCheckClick = true
        }

    }


    override fun selectedOptionInPut(position: Int) {
        lengthConverterViewModel.handleSelectedLengthInput(position)
    }

    override fun selectedOptionResult(position: Int) {
        lengthConverterViewModel.handleSelectedLengthResult(position)
    }


}