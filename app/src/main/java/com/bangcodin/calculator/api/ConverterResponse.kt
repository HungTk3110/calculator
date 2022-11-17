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
    val success: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("result")
    val result: String
)