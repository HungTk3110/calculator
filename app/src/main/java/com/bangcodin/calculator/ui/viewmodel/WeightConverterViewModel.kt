/*
 * *
 *  * Created by Trinh Khac Hung on 11/21/22, 1:42 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/21/22, 1:42 PM
 *
 */

package com.bangcodin.calculator.ui.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class WeightConverterViewModel @Inject constructor(private val application: Application) :
    ViewModel() {

    var isCheckClick = false

    private var _tvInput = MutableLiveData<String>()
    val tvInput: LiveData<String>
        get() = _tvInput
    private var _tvResult = MutableLiveData<String>()
    val tvResult: LiveData<String>
        get() = _tvResult

    private var _tvWeightConverted = MutableLiveData<String>()
    val tvWeightConverted: LiveData<String>
        get() = _tvWeightConverted
    private var _tvWeightConverter = MutableLiveData<String>()
    val tvWeightConverter: LiveData<String>
        get() = _tvWeightConverter

    init {
        _tvInput.value = ""
        _tvResult.value = ""
        _tvWeightConverted.value = "Kg - Kilogram"
        _tvWeightConverter.value = "G - Gam"
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
        _tvResult.value = ""
    }

    fun delete() {
        var str = _tvInput.value.toString()
        if (str.isNotEmpty()) {
            str = str.substring(0, str.length - 1)
        }
        _tvInput.value = str
    }

     fun handleSelectedLengthInput(position: Int) {
        if (!isCheckClick) {
            when (position) {
                0 -> {
                    _tvWeightConverted.value = "Kg - Kilogram"
                }
                1 -> {
                    _tvWeightConverted.value = "G - Gam"
                }
                2 -> {
                    _tvWeightConverted.value = "Ton"
                }
                3 -> {
                    _tvWeightConverted.value = "Lb - Pound"
                }
                4 -> {
                    _tvWeightConverted.value = "Oz - Ounce"
                }
            }
        }
    }

     fun handleSelectedLengthResult(position: Int) {
        if (isCheckClick) {
            when (position) {
                0 -> {
                    _tvWeightConverter.value = "Kg - Kilogram"
                }
                1 -> {
                    _tvWeightConverter.value = "G - Gam"
                }
                2 -> {
                    _tvWeightConverter.value = "Ton"
                }
                3 -> {
                    _tvWeightConverter.value = "Lb - Pound"
                }
                4 -> {
                    _tvWeightConverter.value = "Oz - Ounce"
                }
            }
        }
    }

    fun convert() {
        try {
            val inputPhysical = _tvWeightConverted.value.toString()
            val outputPhysical = _tvWeightConverter.value.toString()
            val result = _tvInput.value.toString().toDouble()
            _tvResult.value =
                converterWeightAction(inputPhysical, outputPhysical, result).toString()
            Log.d("resutl---> ", converterWeightAction(inputPhysical, outputPhysical, result).toString())
        } catch (ex: Exception) {
            Toast.makeText(application, "Input is invalid!", Toast.LENGTH_SHORT).show()
        }
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
