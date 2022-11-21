/*
 * *
 *  * Created by Trinh Khac Hung on 11/21/22, 1:42 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/21/22, 1:42 PM
 *
 */

package com.bangcodin.calculator.ui.viewmodel

import android.app.Application
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.repository.Repository
import com.bangcodin.calculator.ui.adapter.setImageFromResource
import javax.inject.Inject

class CurrencyConverterViewModel @Inject constructor(private val application: Application , private val repository: Repository): ViewModel() {

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
    var isCheckClick = false

    private var _tvInput = MutableLiveData<String>()
    val tvInput: LiveData<String>
        get() = _tvInput
    private var _tvResult = MutableLiveData<String>()
    val tvResult: LiveData<String>
        get() = _tvResult

    private var _tvNationalNeedConvert = MutableLiveData<String>()
    val tvNationalNeedConvert: LiveData<String>
        get() = _tvNationalNeedConvert
    private var _tvNationalConverted = MutableLiveData<String>()
    val tvNationalConverted: LiveData<String>
        get() = _tvNationalConverted

    private var _imgNationalNeedConvert = MutableLiveData<Int>()
    val imgNationalNeedConvert: LiveData<Int>
        get() = _imgNationalNeedConvert
    private var _imgNationalConverted = MutableLiveData<Int>()
    val imgNationalConverted: LiveData<Int>
        get() = _imgNationalConverted

    init {
        _tvInput.value = ""
        _tvResult.value = ""
        _tvNationalNeedConvert.value = "VND - Vietnames Dong"
        _tvNationalConverted.value = "USD - US Dollar "
        _imgNationalNeedConvert.value = R.drawable.ic_vietnam
        _imgNationalConverted.value = R.drawable.ic_united_states
    }


    fun addOne() {
        check0()
        _tvInput.value += "1"
    }

    fun addTwo() {
        check0()
        _tvInput.value += "2"
    }

    fun addThree() {
        check0()
        _tvInput.value += "3"
    }

    fun addFive() {
        check0()
        _tvInput.value += "5"
    }

    fun addSix() {
        check0()
        _tvInput.value += "6"
    }

    fun addFour() {
        check0()
        _tvInput.value += "4"
    }

    fun addSeven() {
        check0()
        _tvInput.value += "7"
    }

    fun addEight() {
        check0()
        _tvInput.value += "8"
    }

    fun addNine() {
        check0()
        _tvInput.value += "9"
    }

    fun addZero() {
        check0()
        _tvInput.value += "0"
    }

    fun addDot() {
        check0()
        _tvInput.value += "."
    }

    private fun check0() {
        if (_tvInput.value.toString() == "0")
            _tvInput.value = ""
    }

    fun clearAll() {
        _tvInput.value = ""
        _tvResult.value = "0"
    }

    fun delete() {
        var str = _tvInput.value.toString()
        if (str.isNotEmpty()) {
            str = str.substring(0, str.length - 1)
        }
        _tvInput.value = str
    }

    fun handleSelectedNationalConverter(position: Int) {
        if (!isCheckClick) {
            when (position) {
                0 -> {
                    _imgNationalNeedConvert.value = R.drawable.ic_united_states
                    _tvNationalNeedConvert.value = "USD - US Dollar "
                }

                1 -> {
                    _imgNationalNeedConvert.value =R.drawable.euro
                    _tvNationalNeedConvert.value = "EUR - Euro "
                }

                2 -> {
                    _imgNationalNeedConvert.value =R.drawable.india
                    _tvNationalNeedConvert.value = "INR - Indian Rupee "
                }

                3 -> {
                    _imgNationalNeedConvert.value =R.drawable.indo
                    _tvNationalNeedConvert.value = "IDR - Indonesian Rupiah "
                }

                4 -> {
                    _imgNationalNeedConvert.value =R.drawable.kr
                    _tvNationalNeedConvert.value = "KRW - South Korean Won "
                }

                5 -> {
                    _imgNationalNeedConvert.value =R.drawable.jp
                    _tvNationalNeedConvert.value = "JPY - Japanese Yen "
                }
                6 -> {
                    _imgNationalNeedConvert.value =R.drawable.ic_vietnam
                    _tvNationalNeedConvert.value = "VND - Vietnames Dong"
                }
            }
        }
    }

    fun handleSelectedNationalConverted(position: Int) {
        if (isCheckClick) {
            when (position) {
                0 -> {
                    _imgNationalConverted.value = R.drawable.ic_united_states
                    _tvNationalConverted.value = "USD - US Dollar "
                }

                1 -> {
                    _imgNationalConverted.value = R.drawable.euro
                    _tvNationalConverted.value = "EUR - Euro "
                }

                2 -> {
                    _imgNationalConverted.value = R.drawable.india
                    _tvNationalConverted.value = "INR - Indian Rupee "
                }

                3 -> {
                    _imgNationalConverted.value = R.drawable.indo
                    _tvNationalConverted.value = "IDR - Indonesian Rupiah "
                }

                4 -> {
                    _imgNationalConverted.value = R.drawable.kr
                    _tvNationalConverted.value = "KRW - South Korean Won "
                }

                5 -> {
                    _imgNationalConverted.value = R.drawable.jp
                    _tvNationalConverted.value = "JPY - Japanese Yen "
                }
                6 -> {
                    _imgNationalConverted.value = R.drawable.ic_vietnam
                    _tvNationalConverted.value = "VND - Vietnames Dong"
                }
            }
        }
    }

    fun Convert(){
        var converter: Double = 0.0
        if (_tvInput.value.toString().trim() != "") {
            try {
                converter = _tvInput.value.toString().toDouble()
            } catch (ex: Exception) {
                Toast.makeText(application, "Input is invalid!", Toast.LENGTH_SHORT).show()
            }

            from = mapLanguageCode[_tvNationalNeedConvert.value].toString()
            to = mapLanguageCode[_tvNationalConverted.value].toString()
            repository.callApi(from, to, converter)
        } else {
            Toast.makeText(application, "Please enter input amount!", Toast.LENGTH_SHORT).show()
        }
    }
}