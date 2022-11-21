package com.bangcodin.calculator.ui.fragment

import android.util.Log
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentWeightConversionBinding
import com.bangcodin.calculator.ui.base.BaseFragment

class WeightFragment : BaseFragment(), BottomSheetKgFragment.OptionConverterKg {
    private lateinit var binding: FragmentWeightConversionBinding
    private val bottomSheetWeight = BottomSheetKgFragment()
    private var isCheckClick = false
    override fun initView(viewBinding: ViewBinding) {
        bottomSheetWeight.optionConverterKg = this
        binding = viewBinding as FragmentWeightConversionBinding
        setOnClick()

    }

    override fun getLayout(): Int {
        return R.layout.fragment_weight_conversion
    }

    override fun initViewModel() {

    }


    private fun setOnClick() {
        val bottomSheet = BottomSheetFragment()
        binding.toolbar.setOnClickListener {
            bottomSheet.show(parentFragmentManager, "BottomSheet")
        }
        binding.tvWeightConverted.setOnClickListener {
            bottomSheetWeight.show(parentFragmentManager, "")
            isCheckClick = false
        }
        binding.tvWeightConverter.setOnClickListener {
            bottomSheetWeight.show(parentFragmentManager, "")
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

        binding.btnAc.setOnClickListener {
            binding.tvInput.text = ""
            binding.tvResult.text = ""
        }

        binding.btnCv.setOnClickListener {
            try {
                val inputPhysical = binding.tvWeightConverted.text.toString()
                val outputPhysical = binding.tvWeightConverter.text.toString()
                val result = binding.tvInput.text.toString().toDouble()
                binding.tvResult.text =
                    converterWeightAction(inputPhysical, outputPhysical, result).toString()
                Log.d("resutl---> ", converterWeightAction(inputPhysical, outputPhysical, result).toString())
            } catch (ex: Exception) {
                Toast.makeText(context, "Input is invalid!", Toast.LENGTH_SHORT).show()
            }

        }

        binding.imgButtonDel.setOnClickListener {
            var str = binding.tvInput.text.toString()
            if (str.isNotEmpty()) {
                str = str.substring(0, str.length - 1)
                binding.tvInput.text = str
            }

        }
    }


    private fun handleSelectedLengthInput(position: Int) {
        if (!isCheckClick) {
            when (position) {
                0 -> {
                    binding.tvWeightConverted.text = "Kg - Kilogram"
                }
                1 -> {
                    binding.tvWeightConverted.text = "G - Gam"
                }
                2 -> {
                    binding.tvWeightConverted.text = "Ton"
                }
                3 -> {
                    binding.tvWeightConverted.text = "Lb - Pound"
                }
                4 -> {
                    binding.tvWeightConverted.text = "Oz - Ounce"
                }
            }
        }
    }

    private fun handleSelectedLengthResult(position: Int) {
        if (isCheckClick) {
            when (position) {
                0 -> {
                    binding.tvWeightConverter.text = "Kg - Kilogram"
                }
                1 -> {
                    binding.tvWeightConverter.text = "G - Gam"
                }
                2 -> {
                    binding.tvWeightConverter.text = "Ton"
                }
                3 -> {
                    binding.tvWeightConverter.text = "Lb - Pound"
                }
                4 -> {
                    binding.tvWeightConverter.text = "Oz - Ounce"
                }
            }
        }
    }

    override fun selectedOptionInput(position: Int) {
        handleSelectedLengthInput(position)
    }

    override fun selectedOptionResult(position: Int) {
        handleSelectedLengthResult(position)
    }

    private fun converterWeightAction(
        inputPhysicalValue: String,
        outputPhysicalValue: String,
        inputValue: Double
    ): Double {
        var result = 0.0
//        Log.d("inputPhysicalValue", inputPhysicalValue);
//        Log.d("outputPhysicalValue", outputPhysicalValue);
//        Log.d("inputValue", Double.toString(inputValue));
        when (inputPhysicalValue) {
            "G - Gam" -> {
                when (outputPhysicalValue) {
                    "Kg - Kilogram" -> {
                        result = inputValue / 1000.0
                    }
                    "Oz - Ounce" -> {
                        result = inputValue * 0.03527396
                    }
                    "Lb - Pound" -> {
                        result = inputValue * 0.002204623
                    }
                }
            }
            "Kg - Kilogram" -> {
                when (outputPhysicalValue) {
                    "G - Gam" -> {
                        result = inputValue * 1000.0
                    }
                    "Oz - Ounce" -> {
                        result = inputValue * 35.27396
                    }
                    "Lb - Pound" -> {
                        result = inputValue * 2.204623
                    }
                }
            }
            "Oz - Ounce" -> {
                when (outputPhysicalValue) {
                    "G - Gam" -> {
                        result = inputValue * 28.34952
                    }
                    "Kg - Kilogram" -> {
                        result = inputValue * 0.02834952
                    }
                    "Lb - Pound" -> {
                        result = inputValue * 0.0625
                    }
                }
            }
            "Lb - Pound" -> {
                when (outputPhysicalValue) {
                    "G - Gam" -> {
                        result = inputValue * 453592.4
                    }
                    "Kg - Kilogram" -> {
                        result = inputValue * 0.4535924
                    }
                    "Oz - Ounce" -> {
                        result = inputValue * 16
                    }
                }
            }

        }
        return result
    }


}