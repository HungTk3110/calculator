package com.bangcodin.calculator.ui.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentWeightConversionBinding
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.viewmodel.WeightConverterViewModel
import javax.inject.Inject

class WeightFragment : BaseFragment(), BottomSheetKgFragment.OptionConverterKg {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var weightConverterViewModel: WeightConverterViewModel
    private lateinit var binding: FragmentWeightConversionBinding
    private val bottomSheetWeight = BottomSheetKgFragment()
    override fun initView(viewBinding: ViewBinding) {

        bottomSheetWeight.optionConverterKg = this
        binding = viewBinding as FragmentWeightConversionBinding
        initViewModel()
        setOnClick()

    }

    override fun getLayout(): Int {
        return R.layout.fragment_weight_conversion
    }

    private fun initViewModel() {
        weightConverterViewModel =
            ViewModelProvider(this, viewmodelFactory)[WeightConverterViewModel::class.java]
        binding.weight = weightConverterViewModel
        binding.lifecycleOwner = this
    }


    private fun setOnClick() {
        val bottomSheet = BottomSheetFragment()
        binding.toolbar.setOnClickListener {
            bottomSheet.show(parentFragmentManager, "BottomSheet")
        }
        binding.tvWeightConverted.setOnClickListener {
            bottomSheetWeight.show(parentFragmentManager, "")
            weightConverterViewModel.isCheckClick = false
        }
        binding.tvWeightConverter.setOnClickListener {
            bottomSheetWeight.show(parentFragmentManager, "")
            weightConverterViewModel.isCheckClick = true
        }


    }

    override fun selectedOptionInput(position: Int) {
        weightConverterViewModel.handleSelectedLengthInput(position)
    }

    override fun selectedOptionResult(position: Int) {
        weightConverterViewModel.handleSelectedLengthResult(position)
    }


}