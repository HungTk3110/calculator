/*
 * *
 *  * Created by Trinh Khac Hung on 9/8/22, 9:56 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/8/22, 9:56 AM
 *
 */

package com.bangcodin.calculator.ui.model

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
