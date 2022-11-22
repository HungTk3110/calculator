/*
 * *
 *  * Created by Trinh Khac Hung on 11/22/22, 5:03 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/21/22, 11:48 AM
 *
 */

package com.bangcodin.calculator.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangcodin.calculator.data.models.History


@Database(entities = [History::class] , version = 1)
abstract class HistoryDatabase : RoomDatabase(){

    abstract fun historyDao() : HistoryDAO
}