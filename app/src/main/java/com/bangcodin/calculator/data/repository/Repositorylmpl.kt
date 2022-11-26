/*
 * *
 *  * Created by Trinh Khac Hung on 11/21/22, 3:59 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/21/22, 3:59 PM
 *
 */

package com.bangcodin.calculator.data.repository

import com.bangcodin.calculator.data.api.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repositorylmpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun callApi(from: String, to: String, amount: Double): ConverterResponse {
        return kotlin.runCatching {
            apiService.getCurrencyConverter(from = from, to = to, amount = amount).body()
        }.getOrNull() ?: ConverterResponse()
    }

}