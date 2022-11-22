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

class LengthConverterViewModel @Inject constructor(private val application: Application) :
    ViewModel() {

    var isCheckClick = false

    private var _tvInput = MutableLiveData<String>()
    val tvInput: LiveData<String>
        get() = _tvInput
    private var _tvResult = MutableLiveData<String>()
    val tvResult: LiveData<String>
        get() = _tvResult

    private var _tvLengthConverted = MutableLiveData<String>()
    val tvLengthConverted: LiveData<String>
        get() = _tvLengthConverted
    private var _tvLengthConverter = MutableLiveData<String>()
    val tvLengthConverter: LiveData<String>
        get() = _tvLengthConverter

    init {
        _tvInput.value = ""
        _tvResult.value = ""
        _tvLengthConverted.value = "Km - Kilomet"
        _tvLengthConverter.value = "m - Met"
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
                    _tvLengthConverted.value = "Km - Kilomet"
                }
                1 -> {
                    _tvLengthConverted.value = "m - Met"
                }
                2 -> {
                    _tvLengthConverted.value = "mm - Milimet"
                }
                3 -> {
                    _tvLengthConverted.value = "in - inch"
                }
                4 -> {
                    _tvLengthConverted.value = "ft - Feet"
                }
                5 -> {
                    _tvLengthConverted.value = "yd - Yard"
                }
                6 -> {
                    _tvLengthConverted.value = "mi - Mile"
                }
            }
        }
    }

    fun handleSelectedLengthResult(position: Int) {
        if (isCheckClick) {
            when (position) {
                0 -> {
                    _tvLengthConverter.value = "Km - Kilomet"
                }
                1 -> {
                    _tvLengthConverter.value = "m - Met"
                }
                2 -> {
                    _tvLengthConverter.value = "mm - Milimet"
                }
                3 -> {
                    _tvLengthConverter.value = "in - inch"
                }
                4 -> {
                    _tvLengthConverter.value = "ft - Feet"
                }
                5 -> {
                    _tvLengthConverter.value = "yd - Yard"
                }
                6 -> {
                    _tvLengthConverter.value = "mi - Mile"
                }
            }
        }
    }

    fun Convert() {
        try {
            val inputPhysical = _tvLengthConverted.value.toString()
            val outputPhysical = _tvLengthConverter.value.toString()
            val input = _tvInput.value.toString().toDouble()
            _tvResult.value =
                converterLengthAction(inputPhysical, outputPhysical, input).toString()
            Log.d(
                "resutl---> ",
                converterLengthAction(inputPhysical, outputPhysical, input).toString()
            )
        } catch (ex: Exception) {
            Toast.makeText(application, "Input is invalid!", Toast.LENGTH_SHORT).show()
        }
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
