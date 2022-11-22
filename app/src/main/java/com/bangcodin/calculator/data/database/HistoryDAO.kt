/*
 * *
 *  * Created by Trinh Khac Hung on 11/22/22, 5:04 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/22/22, 5:04 PM
 *
 */

package com.bangcodin.calculator.data.database

import androidx.room.*
import com.bangcodin.calculator.data.models.History

@Dao
interface HistoryDAO {

    @Query("DELETE FROM history_table")
    fun deleteAllHistory();

    @Query("SELECT * FROM history_table  ")
    fun getAllHistory() :MutableList<History>

    @Insert
    fun insertHistory( history: History?)

    @Delete
    fun deleteHistory( history: History?)

}