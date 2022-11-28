/*
 * *
 *  * Created by Trinh Khac Hung on 9/9/22, 2:06 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/9/22, 2:06 PM
 *
 */

package com.bangcodin.calculator.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.bangcodin.calculator.data.database.HistoryDatabase
import com.bangcodin.calculator.data.models.History
import javax.inject.Inject

class HistoryViewModel @Inject constructor(private val db: HistoryDatabase) : ViewModel() {
    var listData: MutableList<History> = mutableListOf()

    init {
        listData = db.historyDao().getAllHistory()
        listData = reverseList(listData)
    }

    fun deleteAllHistory() {
        db.historyDao().deleteAllHistory()
        listData = mutableListOf()
    }

    fun deleteHistory(history: History) {
        db.historyDao().deleteHistory(history)
        listData = db.historyDao().getAllHistory()
        listData = reverseList(listData)
    }

    private fun <T> reverseList(list: List<T>): ArrayList<T> {
        return (list.indices)
            .map { i: Int -> list[list.size - 1 - i] }
            .toCollection(ArrayList())
    }

}