/*
 * *
 *  * Created by Trinh Khac Hung on 11/19/22, 12:43 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/19/22, 9:14 AM
 *
 */

package com.bangcodin.calculator.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class History (
    @PrimaryKey (autoGenerate = true) val uid : Int?,
    @ColumnInfo (name = "date_time") val dateTime : String?,
    @ColumnInfo (name = "result") val result : String?,
    @ColumnInfo (name = "calculator") val calculator : String?
        )
