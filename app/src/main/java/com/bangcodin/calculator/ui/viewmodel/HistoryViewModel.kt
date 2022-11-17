///*
// * *
// *  * Created by Trinh Khac Hung on 9/9/22, 2:06 PM
// *  * Copyright (c) 2022 . All rights reserved.
// *  * Last modified 9/9/22, 2:06 PM
// *
// */
//
//package com.bangcodin.calculator.ui.viewmodel
//
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.MutableLiveData
//import com.bangcodin.calculator.ui.base.BaseApplication.Companion.app
//import com.bangcodin.calculator.ui.database.HistoryDatabase
//import com.bangcodin.calculator.ui.model.History
//
//class HistoryViewModel : AndroidViewModel(app) {
//
//    val historyDAO = HistoryDatabase.getDatabase( getApplication() )?.historyDao()
//    lateinit var allHistory : MutableLiveData<List<History>>
//
//    init {
//        allHistory = MutableLiveData()
//        getAllHistory()
//    }
//
//    fun getAllHistoryObservers(): MutableLiveData<List<History>> {
//        return allHistory
//    }
//    fun getAllHistory() {
//
//        val list =historyDAO?.getAllHistory()
//        //allHistory.postValue(list)
//    }
//
//    fun insertHistory( history: History){
//        historyDAO?.insertHistory(history)
//        getAllHistory()
//    }
//
//}