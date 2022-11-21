/*
 * *
 *  * Created by Trinh Khac Hung on 9/8/22, 10:10 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/8/22, 10:10 AM
 *
 */

package com.bangcodin.calculator.ui.database

import androidx.room.*
import com.bangcodin.calculator.models.History

@Dao
interface HistoryDAO {

    @Query("DELETE FROM history_table")
    fun deleteAllHistory();

    @Query("SELECT * FROM history_table  ")
    fun getAllHistory() :List<History>

    @Insert
    fun insertHistory( history: History?)

    @Delete
    fun deleteHistory( history: History?)

}