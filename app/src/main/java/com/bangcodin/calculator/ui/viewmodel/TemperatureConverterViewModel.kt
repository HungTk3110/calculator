/*
 * *
 *  * Created by Trinh Khac Hung on 11/21/22, 1:42 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/21/22, 1:42 PM
 *
 */

package com.bangcodin.calculator.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat
import javax.inject.Inject

class TemperatureConverterViewModel @Inject constructor(private val application: Application) :
    ViewModel() {

    lateinit var selectedUnit: String

    private var _tvInput = MutableLiveData<String>()
    val tvInput: LiveData<String>
        get() = _tvInput
    private var _tvResult = MutableLiveData<String>()
    val tvResult: LiveData<String>
        get() = _tvResult
    private var _tvResult1 = MutableLiveData<String>()
    val tvResult1: LiveData<String>
        get() = _tvResult1

    private var _tvAnswer = MutableLiveData<String>()
    val tvAnswer: LiveData<String>
        get() = _tvAnswer
    private var _tvAnswer1 = MutableLiveData<String>()
    val tvAnswer1: LiveData<String>
        get() = _tvAnswer1
    var _type = MutableLiveData<String>()
    val type: LiveData<String>
        get() = _type

    init {
        _tvInput.value = ""
        _tvResult.value = ""
        _tvResult1.value = ""
        _tvAnswer.value = ""
        _tvAnswer1.value = ""
        _type.value = "Celsius "
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
        _tvResult1.value = ""
    }

    fun delete() {
        var str = _tvInput.value.toString()
        if (str.isNotEmpty()) {
            str = str.substring(0, str.length - 1)
        }
        _tvInput.value = str
    }


    fun convert() {
        val df = DecimalFormat("#.###")
        val temperature = _tvInput.value.toString().trim()
        val tempNo = temperature.toDouble()
        selectedUnit = "Celsius"
        if (temperature.isNotEmpty() && temperature != "0") {
            if (selectedUnit == "Celsius") {
                _tvAnswer.value = "Fahrenheit"
                _tvAnswer1.value = "Kelvin"
                _tvResult.value = df.format((tempNo - 9 / 5) + 32).toString()
                _tvResult1.value = df.format(tempNo + 273.15).toString()
            } else if (selectedUnit == "Kelvin") {
                _tvAnswer.value = "Fahrenheit"
                _tvAnswer1.value = "Celsius"
                _tvResult.value = ((tempNo - 273.15) * 9 / 5 + 32).toString()
                _tvResult1.value = (tempNo - 273.15).toString()
            } else if (selectedUnit == "Fahrenheit") {
                _tvAnswer.value = "Celsius"
                _tvAnswer1.value = "Kelvin"
                _tvResult.value = ((tempNo - 52) * 5 / 9).toString()
                _tvResult1.value = ((tempNo - 32) * 5 / 9 + 273.15).toString()
            }
        }
    }

}
