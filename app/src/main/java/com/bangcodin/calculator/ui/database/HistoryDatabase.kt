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
import com.bangcodin.calculator.ui.fragment.CalculatorFragment
import com.bangcodin.calculator.ui.model.History


@Database(entities = [History::class] , version = 1)
abstract class HistoryDatabase : RoomDatabase(){

    abstract fun historyDao() : HistoryDAO

    companion object{
        private var INSTANCE : HistoryDatabase? = null
        fun getDatabase(context: Context) : HistoryDatabase{

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HistoryDatabase::class.java,
                    "history_databse"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
        fun destroyInstance() {
            INSTANCE = null
        }
        }
}