/*
 * *
 *  * Created by Nguyen Van Thai on 9/10/22, 9:09 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/10/22, 9:09 AM
 *
 */

package com.bangcodin.calculator.api

import com.google.gson.annotations.SerializedName

data class ConverterResponse (
    @SerializedName("success")
    var success: String? = "",

    @SerializedName("date")
    val date: String ? = null,

    @SerializedName("result")
    var result: String ? = null
)
const val API_KEY = "ylvzO8adSnv6ZEZ2gHwgtN5qwoLhWmLy"
