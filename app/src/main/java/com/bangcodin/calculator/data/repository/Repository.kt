/*
 * *
 *  * Created by Trinh Khac Hung on 11/21/22, 3:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/21/22, 3:55 PM
 *
 */

package com.bangcodin.calculator.data.repository

import com.bangcodin.calculator.data.api.ConverterResponse

interface Repository {
     fun callApi(from: String, to: String, amount: Double) : ConverterResponse
}