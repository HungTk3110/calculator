package com.bangcodin.calculator.ui.fragment

import android.util.Log
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentLengthConversionBinding
import com.bangcodin.calculator.ui.base.BaseFragment

class LengthFragment : BaseFragment(), BottomSheetLengthFragment.OptionConverterKm {
    private var isCheckClick = false
    private lateinit var binding: FragmentLengthConversionBinding
    private val bottomSheetLength = BottomSheetLengthFragment()
    override fun initView(viewBinding: ViewBinding) {
        bottomSheetLength.optionConverterKm = this
        binding = viewBinding as FragmentLengthConversionBinding
        setOnClick()

    }

    override fun getLayout(): Int {
        return R.layout.fragment_length_conversion
    }

    private fun setOnClick() {
        val bottomSheet = BottomSheetFragment()
        binding.toolbar.setOnClickListener {
            bottomSheet.show(parentFragmentManager, "BottomSheet")
        }
        binding.lengthConverted.setOnClickListener {
            bottomSheetLength.show(parentFragmentManager, "BottomSheetLength")
            isCheckClick = false
        }
        binding.lengthConverter.setOnClickListener {
            bottomSheetLength.show(parentFragmentManager, "BottomSheetLength")
            isCheckClick = true
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

        binding.btnAcLenght.setOnClickListener {
            binding.tvInput.text = ""
            binding.tvResult.text = ""
        }

        binding.imgButtonDel.setOnClickListener{
            var str = binding.tvInput.text.toString()
            if (str.isNotEmpty()){
                str = str.substring(0, str.length -1)
                binding.tvInput.text = str
            }
        }
        binding.btnCv.setOnClickListener {
            try {
                val inputPhysical = binding.tvLengthConverted.text.toString()
                val outputPhysical = binding.tvLengthConverter.text.toString()
                val result = binding.tvInput.text.toString().toDouble()
                binding.tvResult.text =
                    converterLengthAction(inputPhysical, outputPhysical, result).toString()
                Log.d("resutl---> ", converterLengthAction(inputPhysical, outputPhysical, result).toString())
            } catch (ex: Exception) {
                Toast.makeText(context, "Input is invalid!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun handleSelectedLengthInput(position: Int) {
        if (!isCheckClick) {
            when (position) {
                0 -> {
                    binding.tvLengthConverted.text = "Km - Kilomet"
                }
                1 -> {
                    binding.tvLengthConverted.text = "m - Met"
                }
                2 -> {
                    binding.tvLengthConverted.text = "mm - Milimet"
                }
                3 -> {
                    binding.tvLengthConverted.text = "in - inch"
                }
                4 -> {
                    binding.tvLengthConverted.text = "ft - Feet"
                }
                5 -> {
                    binding.tvLengthConverted.text = "yd - Yard"
                }
                6 -> {
                    binding.tvLengthConverted.text = "mi - Mile"
                }
            }
        }
    }

    private fun handleSelectedLengthResult(position: Int) {
        if (isCheckClick) {
            when (position) {
                0 -> {
                    binding.tvResult.text = "Km - Kilomet"
                }
                1 -> {
                    binding.tvResult.text = "m - Met"
                }
                2 -> {
                    binding.tvResult.text = "mm - Milimet"
                }
                3 -> {
                    binding.tvResult.text = "in - inch"
                }
                4 -> {
                    binding.tvResult.text = "ft - Feet"
                }
                5 -> {
                    binding.tvResult.text = "yd - Yard"
                }
                6 -> {
                    binding.tvResult.text = "mi - Mile"
                }
            }
        }
    }

    override fun selectedOptionInPut(position: Int) {
        handleSelectedLengthInput(position)
    }

    override fun selectedOptionResult(position: Int) {
        handleSelectedLengthResult(position)
    }

    private fun converterLengthAction(
        inputPhysicalValue: String,
        outputPhysicalValue: String,
        inputValue: Double
    ): Double {
        var result = 0.0
        when (inputPhysicalValue) {
            "Km - Kilomet" -> {
                when (outputPhysicalValue) {
                    "m - Met" -> {
                        result = inputValue * 1000.0
                    }
                    "mm - Milimet" -> {
                        result = inputValue * 1000000
                    }
                    "in - inch" -> {
                        result = inputValue * 39370.078740157
                    }
                    "ft - Feet" -> {
                        result = inputValue * 3280.84
                    }
                    "yd - Yard" -> {
                        result = inputValue * 1093.61
                    }
                    "mi - Mile" -> {
                        result = inputValue * 0.621371
                    }
                }
            }
            "m -Met" -> {
                when (outputPhysicalValue) {
                    "Km - Kilomet" -> {
                        result = inputValue * 0.001
                    }
                    "mm - Milimet" -> {
                        result = inputValue * 1000
                    }
                    "in - inch" -> {
                        result = inputValue * 39.3701
                    }
                    "ft - Feet" -> {
                        result = inputValue * 3.2808
                    }
                    "yd - Yard" -> {
                        result = inputValue * 1.0936
                    }
                    "mi - Mile" -> {
                        result = inputValue * 0.00062137
                    }
                }
            }
            "mm - Milimet" -> {
                when (outputPhysicalValue) {
                    "Km - Kilomet" -> {
                        result = inputValue * 0.000001
                    }
                    "m -Met" -> {
                        result = inputValue * 0.001
                    }
                    "in - inch" -> {
                        result = inputValue * 0.03937
                    }
                    "ft - Feet" -> {
                        result = inputValue * 0.00328084
                    }
                    "yd - Yard" -> {
                        result = inputValue * 0.00109361
                    }
                    "mi - Mile" -> {
                        result = inputValue * (6.21371192237334 * Math.pow(10.0, (-7.0)))
                    }
                }
            }
            "in - inch" -> {
                when (outputPhysicalValue) {
                    "Km - Kilomet" -> {
                        result = inputValue * 0.0000254
                    }
                    "mm - Milimet" -> {
                        result = inputValue * 25.4
                    }
                    "m -Met" -> {
                        result = inputValue * 0.0254
                    }
                    "ft - Feet" -> {
                        result = inputValue * 0.083333
                    }
                    "yd - Yard" -> {
                        result = inputValue * 0.027778
                    }
                    "mi - Mile" -> {
                        result = inputValue * 0.0000157828
                    }
                }
            }

            "ft - Feet" -> {
                when (outputPhysicalValue) {
                    "Km - Kilomet" -> {
                        result = inputValue * 0.0003048
                    }
                    "mm - Milimet" -> {
                        result = inputValue * 304.8
                    }
                    "in - inch" -> {
                        result = inputValue * 12
                    }
                    "m -Met" -> {
                        result = inputValue * 0.3048
                    }
                    "yd - Yard" -> {
                        result = inputValue * 0.333333
                    }
                    "mi - Mile" -> {
                        result = inputValue * 0.00018939
                    }
                }
            }

            "yd - Yard" -> {
                when (outputPhysicalValue) {
                    "Km - Kilomet" -> {
                        result = inputValue * 0.0009144
                    }
                    "mm - Milimet" -> {
                        result = inputValue * 914.4
                    }
                    "in - inch" -> {
                        result = inputValue * 36
                    }
                    "ft - Feet" -> {
                        result = inputValue * 3
                    }
                    "m -Met" -> {
                        result = inputValue * 0.9144
                    }
                    "mi - Mile" -> {
                        result = inputValue * 0.00056818
                    }
                }
            }

            "mi - Mile" -> {
                when (outputPhysicalValue) {
                    "Km - Kilomet" -> {
                        result = inputValue * 1.6093
                    }
                    "mm - Milimet" -> {
                        result = inputValue * 1609344
                    }
                    "in - inch" -> {
                        result = inputValue * 63360
                    }
                    "ft - Feet" -> {
                        result = inputValue * 5280
                    }
                    "yd - Yard" -> {
                        result = inputValue * 1760
                    }
                    "m -Met" -> {
                        result = inputValue * 1609.34
                    }
                }
            }

        }
        return result
    }


}