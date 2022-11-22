/*
 * *
 *  * Created by Trinh Khac Hung on 9/9/22, 2:06 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/9/22, 2:06 PM
 *
 */

package com.bangcodin.calculator.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangcodin.calculator.data.database.HistoryDatabase
import com.bangcodin.calculator.data.models.History
import javax.inject.Inject

class HistoryViewModel @Inject constructor(private val db: HistoryDatabase) : ViewModel() {
     var listData:MutableList<History> = mutableListOf()

    init {
        listData = db.historyDao().getAllHistory()
    }
    fun deleteHistory(){
        db.historyDao().deleteAllHistory()
        listData = mutableListOf()
    }



}