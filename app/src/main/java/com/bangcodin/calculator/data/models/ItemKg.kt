/*
 * *
 *  * Created by Nguyen Van Thai on 9/18/22, 5:56 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/18/22, 5:56 PM
 *
 */

package com.bangcodin.calculator.data.models

import androidx.annotation.StringRes

data class ItemKg(
    @StringRes val stringResourceId: Int,
    var isCheckStatusKg: Boolean = false
)