package com.bangcodin.calculator.di.Module

import android.app.Application
import androidx.room.Room
import com.bangcodin.calculator.ui.database.HistoryDAO
import com.bangcodin.calculator.ui.database.HistoryDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomDbModule {
    @Provides
    @Singleton
    internal fun provideDatabase(application: Application): HistoryDatabase {
        return Room.databaseBuilder(
            application, HistoryDatabase::class.java, "DataBase")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideCharacterDao(historyDatabase: HistoryDatabase): HistoryDAO {
        return historyDatabase.historyDao()
    }

}