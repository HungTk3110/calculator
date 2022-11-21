/*
 * *
 *  * Created by Trinh Khac Hung on 9/8/22, 10:17 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/8/22, 10:17 AM
 *
 */

package com.bangcodin.calculator.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangcodin.calculator.models.History


@Database(entities = [History::class] , version = 1)
abstract class HistoryDatabase : RoomDatabase(){

    abstract fun historyDao() : HistoryDAO
}