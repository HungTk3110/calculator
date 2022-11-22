/*
 * *
 *  * Created by Trinh Khac Hung on 11/22/22, 5:02 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/21/22, 4:24 PM
 *
 */

package com.bangcodin.calculator.data.api

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
