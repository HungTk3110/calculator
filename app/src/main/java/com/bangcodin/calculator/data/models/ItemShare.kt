/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 2:47 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 2:47 PM
 *
 */

package com.bangcodin.calculator.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ItemShare(
    @StringRes val stringShare: Int,
    @DrawableRes val imageShare: Int
)