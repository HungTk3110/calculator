/*
 * *
 *  * Created by Nguyen Van Thai on 9/10/22, 8:58 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/10/22, 8:58 AM
 *
 */

package com.bangcodin.calculator.api

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("convert?")
    fun getCurrencyConverter(
        @Header("apikey") apikey: String = ApiClient.API_KEY,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("amount") amount: Double
    ) : Call<ConverterResponse>
}