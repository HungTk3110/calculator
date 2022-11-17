/*
 * *
 *  * Created by Nguyen Van Thai on 8/30/22, 2:17 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/30/22, 2:17 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import android.util.Log
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.api.ApiClient
import com.bangcodin.calculator.api.ConverterResponse
import com.bangcodin.calculator.databinding.FragmentCurrencyConversionBinding
import com.bangcodin.calculator.ui.base.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.NumberFormat

class CurrencyConversionFragment : BaseFragment(), BottomSheetNational.OptionConverter {
    private val mapLanguageCode: HashMap<String, String> = hashMapOf(
        "USD - US Dollar " to "USD",
        "EUR - Euro " to "EUR",
        "INR - Indian Rupee " to "INR",
        "IDR - Indonesian Rupiah " to "IDR",
        "KRW - South Korean Won " to "KRW",
        "JPY - Japanese Yen " to "JPY",
        "VND - Vietnames Dong" to "VND"
    )

    private var from = ""
    private var to = ""
    private var isCheckClick = false
    private val bottomSheetNational = BottomSheetNational()
    private lateinit var binding: FragmentCurrencyConversionBinding
    override fun initView(viewBinding: ViewBinding) {
        binding = viewBinding as FragmentCurrencyConversionBinding
        bottomSheetNational.optionConverter = this
        setOnClickItem()
        binding.tvNationalNeedConvert.setOnClickListener {
            bottomSheetNational.show(parentFragmentManager, "")
            isCheckClick = false
        }

        binding.tvNationalConverted.setOnClickListener {
            bottomSheetNational.show(parentFragmentManager, "")
            isCheckClick = true
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_currency_conversion
    }


    private fun setOnClickItem() {
        val bottomSheet = BottomSheetFragment()
        binding.toolbar.setOnClickListener {
            bottomSheet.show(parentFragmentManager, "BottomSheet")
        }

        binding.btn1.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "1"
        }

        binding.btn0.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "0"
        }

        binding.btn2.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "2"
        }

        binding.btn3.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "3"
        }

        binding.btn4.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "4"
        }

        binding.btn5.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "5"
        }

        binding.btn6A.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "6"
        }

        binding.btn7.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "7"
        }

        binding.btn8.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "8"
        }

        binding.btn9.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "9"
        }

        binding.btn.setOnClickListener {
            binding.tvInputAmount.text = binding.tvInputAmount.text.toString() + "."
        }

        binding.btnAc.setOnClickListener {
            binding.tvInputAmount.text = ""
            binding.tvValueConverted.text = ""
        }

        binding.btnDel.setOnClickListener{
            var str = binding.tvInputAmount.text.toString()
            if (str.isNotEmpty()){
                str = str.substring(0, str.length -1)
                binding.tvInputAmount.text = str
            }
        }




        binding.btnCv.setOnClickListener {
            var converter: Double = 0.0
            if (binding.tvInputAmount.text.toString().trim() != "") {
                try {
                    converter = binding.tvInputAmount.text.toString().toDouble()
                } catch (ex: Exception) {
                    Toast.makeText(context, "Input is invalid!", Toast.LENGTH_SHORT).show()
                }

                from = mapLanguageCode[binding.tvNationalNeedConvert.text].toString()
                to = mapLanguageCode[binding.tvNationalConverted.text].toString()
                callApiConverter(from, to, converter)
            } else {
                Toast.makeText(context, "Please enter input amount!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun callApiConverter(from: String, to: String, amount: Double) {
        ApiClient.newInstance(requireContext())
            .getCurrencyConverter(from = from, to = to, amount = amount)
            .enqueue(object : Callback<ConverterResponse> {
                override fun onResponse(
                    call: Call<ConverterResponse>,
                    response: Response<ConverterResponse>
                ) {
                    if (response.isSuccessful && response.code() == 200) {
                        val formatter: NumberFormat = DecimalFormat("#,###")
                        binding.tvValueConverted.text = formatter.format(response.body()?.result!!.toDouble())
                        binding.tvDateUpdated.text =
                            "Data comes from Webull, updated on " + response.body()?.date
                    }
                }

                override fun onFailure(call: Call<ConverterResponse>, t: Throwable) {
                    Log.e("ERROR---->", t.message.toString())
                    Toast.makeText(context, "Input is invalid!", Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun handleSelectedNationalConverter(position: Int) {
        if (!isCheckClick) {
            when (position) {
                0 -> {
                    binding.imgNationalNeedConvert.setImageResource(R.drawable.ic_united_states)
                    binding.tvNationalNeedConvert.text = "USD - US Dollar "
                }

                1 -> {
                    binding.imgNationalNeedConvert.setImageResource(R.drawable.euro)
                    binding.tvNationalNeedConvert.text = "EUR - Euro "
                }

                2 -> {
                    binding.imgNationalNeedConvert.setImageResource(R.drawable.india)
                    binding.tvNationalNeedConvert.text = "INR - Indian Rupee "
                }

                3 -> {
                    binding.imgNationalNeedConvert.setImageResource(R.drawable.indo)
                    binding.tvNationalNeedConvert.text = "IDR - Indonesian Rupiah "
                }

                4 -> {
                    binding.imgNationalNeedConvert.setImageResource(R.drawable.kr)
                    binding.tvNationalNeedConvert.text = "KRW - South Korean Won "
                }

                5 -> {
                    binding.imgNationalNeedConvert.setImageResource(R.drawable.jp)
                    binding.tvNationalNeedConvert.text = "JPY - Japanese Yen "
                }
                6 -> {
                    binding.imgNationalNeedConvert.setImageResource(R.drawable.ic_vietnam)
                    binding.tvNationalNeedConvert.text = "VND - Vietnames Dong"
                }
            }
        }
    }

    private fun handleSelectedNationalConverted(position: Int) {
        if (isCheckClick) {
            when (position) {
                0 -> {
                    binding.imgNationalConverted.setImageResource(R.drawable.ic_united_states)
                    binding.tvNationalConverted.text = "USD - US Dollar "
                }

                1 -> {
                    binding.imgNationalConverted.setImageResource(R.drawable.euro)
                    binding.tvNationalConverted.text = "EUR - Euro "
                }

                2 -> {
                    binding.imgNationalConverted.setImageResource(R.drawable.india)
                    binding.tvNationalConverted.text = "INR - Indian Rupee "
                }

                3 -> {
                    binding.imgNationalConverted.setImageResource(R.drawable.indo)
                    binding.tvNationalConverted.text = "IDR - Indonesian Rupiah "
                }

                4 -> {
                    binding.imgNationalConverted.setImageResource(R.drawable.kr)
                    binding.tvNationalConverted.text = "KRW - South Korean Won "
                }

                5 -> {
                    binding.imgNationalConverted.setImageResource(R.drawable.jp)
                    binding.tvNationalConverted.text = "JPY - Japanese Yen "
                }
                6 -> {
                    binding.imgNationalConverted.setImageResource(R.drawable.ic_vietnam)
                    binding.tvNationalConverted.text = "VND - Vietnames Dong"
                }
            }
        }
    }

    override fun selectedOptionConverter(position: Int) {
        handleSelectedNationalConverter(position)
    }

    override fun selectedOptionConverted(position: Int) {
        handleSelectedNationalConverted(position)
    }

}