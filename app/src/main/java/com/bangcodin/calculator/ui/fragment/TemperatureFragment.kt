package com.bangcodin.calculator.ui.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentTemperatureConversionBinding
import com.bangcodin.calculator.ui.base.BaseFragment
import java.text.DecimalFormat

class TemperatureFragment : BaseFragment() {
    private lateinit var selectedUnit: String
    private lateinit var binding: FragmentTemperatureConversionBinding
    override fun initView(viewBinding: ViewBinding) {
        binding = viewBinding as FragmentTemperatureConversionBinding
        setOnClick()

    }

    override fun getLayout(): Int {
        return R.layout.fragment_temperature_conversion
    }

    private fun setOnClick() {
        val bottomSheet = BottomSheetFragment()
        binding.toolbar.setOnClickListener {
            bottomSheet.show(parentFragmentManager, "BottomSheet")
        }

        binding.btn1.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "1"
        }

        binding.btn0.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "0"
        }

        binding.btn2.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "2"
        }

        binding.btn3.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "3"
        }

        binding.btn4.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "4"
        }

        binding.btn5.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "5"
        }

        binding.btn6A.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "6"
        }

        binding.btn7.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "7"
        }

        binding.btn8.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "8"
        }

        binding.btn9.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "9"
        }

        binding.btn.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "."
        }

        binding.btnActerm.setOnClickListener {
            binding.tvInput.text = ""
            binding.tvResult.text = ""
            binding.tvResult1.text = ""
        }

        binding.imgButtonDel.setOnClickListener {
            var str = binding.tvInput.text.toString()
            if (str.isNotEmpty()) {
                str = str.substring(0, str.length - 1)
                binding.tvInput.text = str
            }
        }

        binding.btnCv.setOnClickListener {
            convertTempera()
        }

        binding.type.setOnClickListener {
            showAlertDialog()
        }



    }

    private fun showAlertDialog() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
        alertDialog.setTitle("Select Unit") //Setting title for alertBox
        val items = arrayOf("Fahrenheit", "Celsius" , "Kelvin")
        val checkedItem = -1
        alertDialog.setSingleChoiceItems(items, checkedItem,
            DialogInterface.OnClickListener { dialog, which ->
                selectedUnit = items[which]
                binding.type.setText(items[which])
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

    private fun convertTempera(){
        val df = DecimalFormat("#.###")
        val temperature = binding.tvInput.text.toString().trim()
        val tempNo = temperature.toDouble()
        selectedUnit = "Celsius"
        if (temperature.isNotEmpty() && temperature != "0"){
            if (selectedUnit == "Celsius"){
                binding.tvAnswer.text = "Fahrenheit"
                binding.tvAnswer1.text = "Kelvin"
                binding.tvResult.text = df.format((tempNo - 9/5) + 32).toString()
                binding.tvResult1.text = df.format(tempNo + 273.15).toString()
            }else if (selectedUnit == "Kelvin"){
                binding.tvAnswer.text = "Fahrenheit"
                binding.tvAnswer1.text = "Celsius"
                binding.tvResult.text = ((tempNo - 273.15) * 9/5 + 32).toString()
                binding.tvResult1.text = (tempNo - 273.15).toString()
            }else if (selectedUnit == "Fahrenheit"){
                binding.tvAnswer.text = "Celsius"
                binding.tvAnswer1.text = "Kelvin"
                binding.tvResult.text = ((tempNo - 52) * 5/9).toString()
                binding.tvResult1.text = ((tempNo - 32) * 5/9 + 273.15).toString()
            }
        }
    }
}