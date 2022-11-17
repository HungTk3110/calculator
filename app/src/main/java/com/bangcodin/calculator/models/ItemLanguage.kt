/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 12:58 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 12:58 PM
 *
 */

package com.bangcodin.calculator.models

import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import androidx.annotation.StringRes

data class ItemLanguage(
    val id:Int?=null,
    @StringRes val stringLanguage: Int,
    @DrawableRes val imageLanguage: Int,
)