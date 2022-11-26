/*
 * *
 *  * Created by Trinh Khac Hung on 11/17/22, 10:41 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/17/22, 10:41 AM
 *
 */

package com.bangcodin.calculator.ui.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangcodin.calculator.data.database.HistoryDatabase
import javax.inject.Inject
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class CalculatorViewModel @Inject constructor(
    private val application: Application,
    private val historyDatabase: HistoryDatabase
) : ViewModel() {

    private val pi = "3.14159265"
    private var _tvInput = MutableLiveData<String>()
    val tvInput: LiveData<String>
        get() = _tvInput
    private var _tvResult = MutableLiveData<String>()
    val tvResult: LiveData<String>
        get() = _tvResult

    init {
        _tvInput.value = ""
        _tvResult.value = "0"
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

    fun addNgoacTrai() {
        _tvInput.value += "("
    }

    fun addNgoacPhai() {
        _tvInput.value += ")"
    }

    fun clearAll() {
        _tvInput.value = ""
        _tvResult.value = ""
    }

    fun delete() {
        var str = _tvInput.value.toString()
        if (str.isNotEmpty()) {
            if (str.length >= 3 && ((str.substring(
                    str.length - 3,
                    str.length
                ) == "sin") || (str.substring(str.length - 3, str.length) == "cos") ||
                        (str.substring(str.length - 3, str.length) == "tan")
                        || (str.substring(str.length - 3, str.length) == "cot"))
            ) {
                str = str.substring(0, str.length -3)
            } else
                str = str.substring(0, str.length - 1)
        }
        _tvInput.value = str
    }

    fun addPi() {
        _tvInput.value += "π"
    }

    fun sin() {
        _tvInput.value += "sin"
    }

    fun cos() {
        _tvInput.value += "cos"
    }

    fun tan() {
        _tvInput.value += "tan"
    }

    fun cot() {
        _tvInput.value += "cot"
    }

    fun push() {
        val str: String = _tvInput.value.toString()
        if (str.isNotEmpty() && str.substring(str.length - 1) != "+" && str.substring(str.length - 1) != "-"
            && str.substring(str.length - 1) != "×" && str.substring(str.length - 1) != "÷"
        ) {
            _tvInput.value += "+"
        }
    }

    fun minus() {
        val str: String = _tvInput.value.toString()
        if (str.isNotEmpty() && str.substring(str.length - 1) != "+" && str.substring(str.length - 1) != "-"
            && str.substring(str.length - 1) != "×" && str.substring(str.length - 1) != "÷"
        ) {
            _tvInput.value += "-"
        }
    }

    fun multiplied() {
        val str: String = _tvInput.value.toString()
        if (str.isNotEmpty() && str.substring(str.length - 1) != "+" && str.substring(str.length - 1) != "-"
            && str.substring(str.length - 1) != "×" && str.substring(str.length - 1) != "÷"
        ) {
            _tvInput.value += "×"
        }
    }

    fun division() {
        val str: String = _tvInput.value.toString()
        if (str.isNotEmpty() && str.substring(str.length - 1) != "+" && str.substring(str.length - 1) != "-"
            && str.substring(str.length - 1) != "×" && str.substring(str.length - 1) != "÷"
        ) {
            _tvInput.value += "÷"
        }
    }

    fun equal() {
        var str: String = _tvInput.value.toString()
        var result = 0.0
        str = str.replace("÷","/")
        str = str.replace("×","*")
        str = str.replace("π",pi)
        try {
            result = evaluate(str)
        } catch (e: RuntimeException) {
            Toast.makeText(application, e.message, Toast.LENGTH_SHORT).show()
        }
        val r = result.toString()
        if (r.substring(r.indexOf(".") + 1) == "0")
            _tvResult.value = r.substring(0, r.indexOf("."))
        else
            _tvResult.value = r
    }

    private fun evaluate(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0
            fun nextChar() {
                ch = if (++pos < str.length) str[pos].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("không thực hiện được phép tính ")
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.code)) x += parseTerm()
                    else if (eat('-'.code)) x -= parseTerm()
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = 0.0
                try {
                    x = parseFactor()
                } catch (e: RuntimeException) {
                    Toast.makeText(application, e.message, Toast.LENGTH_SHORT).show()
                }
                while (true) {
                    if (eat('*'.code)) x *= parseFactor()
                    else if (eat('/'.code)) x /= parseFactor()
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.code)) return parseFactor()
                if (eat('-'.code)) return -parseFactor()
                var x: Double
                val startPos = pos
                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {
                    while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()
                    x = str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.code && ch <= 'z'.code) {
                    while (ch >= 'a'.code && ch <= 'z'.code) nextChar()
                    val func = str.substring(startPos, pos)
                    x = parseFactor()
                    x =
                        when (func) {
                            "sqrt" -> sqrt(x)
                            "sin" -> kotlin.math.sin(
                                Math.toRadians(x)
                            )
                            "cos" -> kotlin.math.cos(
                                Math.toRadians(x)
                            )
                            "cot" -> 1 / kotlin.math.tan(Math.toRadians(x))
                            "tan" -> kotlin.math.tan(Math.toRadians(x))
                            "log" -> log10(x)
                            "ln" -> ln(x)
                            else -> throw RuntimeException(
                                "không thực hiện được phép tính "
                            )
                        }
                } else {
                    throw RuntimeException("không thực hiện được phép tính")

                }
                if (eat('^'.code)) x = x.pow(parseFactor())
                return x
            }
        }.parse()
    }

    private fun check0() {
        if (_tvInput.value.toString() == "0")
            _tvInput.value = ""
    }
}