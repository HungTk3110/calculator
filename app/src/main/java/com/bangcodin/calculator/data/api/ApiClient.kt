///*
// * *
// *  * Created by Nguyen Van Thai on 9/10/22, 8:47 AM
// *  * Copyright (c) 2022 . All rights reserved.
// *  * Last modified 9/10/22, 8:47 AM
// *
// */
//
//package com.bangcodin.calculator.api
//
//import android.content.Context
//import com.google.gson.GsonBuilder
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//object ApiClient {
//    const val BASE_URL = "https://api.apilayer.com/exchangerates_data/"
//    const val DEFAULT_TIMEOUT = 60L
//    const val API_KEY = "ylvzO8adSnv6ZEZ2gHwgtN5qwoLhWmLy"
//    private var apiService: ApiService?= null
//    fun newInstance(context: Context): ApiService {
//        if (apiService == null) {
//            apiService = createApiInterface(context)
//        }
//        return apiService!!
//    }
//
//    private fun createApiInterface(context: Context) : ApiService {
//        val gson = GsonBuilder()
//            .setLenient()
//            .create()
//        val retrofit: Retrofit = Retrofit.Builder()
//            .client(createOkHttpClient(context))
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//        return retrofit.create(ApiService::class.java)
//    }
//    private fun createOkHttpClient(context: Context) : okhttp3.OkHttpClient {
//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        return okhttp3.OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//            .build()
//    }
//}