package com.bangcodin.calculator.ui.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentTemperatureConversionBinding
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.viewmodel.TemperatureConverterViewModel
import javax.inject.Inject

class TemperatureFragment : BaseFragment() {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var temperatureConverterViewModel: TemperatureConverterViewModel
    private lateinit var binding: FragmentTemperatureConversionBinding
    override fun initView(viewBinding: ViewBinding) {

        binding = viewBinding as FragmentTemperatureConversionBinding
        initViewModel()
        setOnClick()

    }

    override fun getLayout(): Int {
        return R.layout.fragment_temperature_conversion
    }

    private fun initViewModel() {
        temperatureConverterViewModel =
            ViewModelProvider(this, viewmodelFactory)[TemperatureConverterViewModel::class.java]
        binding.temperature = temperatureConverterViewModel
        binding.lifecycleOwner = this
    }

    private fun setOnClick() {
        val bottomSheet = BottomSheetFragment()
        binding.toolbar.setOnClickListener {
            bottomSheet.show(parentFragmentManager, "BottomSheet")
        }

        binding.type.setOnClickListener {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(requireContext())
            alertDialog.setTitle("Select Unit") //Setting title for alertBox
            val items = arrayOf("Fahrenheit", "Celsius", "Kelvin")
            val checkedItem = -1
            alertDialog.setSingleChoiceItems(items, checkedItem,
                DialogInterface.OnClickListener { dialog, which ->
                    temperatureConverterViewModel.selectedUnit = items[which]
                    temperatureConverterViewModel._type.value = (items[which])
                })
            alertDialog.setPositiveButton(
                android.R.string.ok,
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
            val alert: AlertDialog = alertDialog.create()
            alert.setCanceledOnTouchOutside(false)
            alert.show()

        }

    }


}