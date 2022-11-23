/*
 * *
 *  * Created by Trinh Khac Hung on 11/22/22, 5:03 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/22/22, 5:03 PM
 *
 */

package com.bangcodin.calculator.data.api

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("convert?")
    fun getCurrencyConverter(
        @Header("apikey") apikey: String  = API_KEY,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("amount") amount: Double
    ) : Response<ConverterResponse>
}