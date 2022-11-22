/*
 * *
 *  * Created by Nguyen Van Thai on 8/30/22, 9:23 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/30/22, 9:23 AM
 *
 */

package com.bangcodin.calculator.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ItemBottomSheet(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    var isCheckStatus: Boolean = false
)
