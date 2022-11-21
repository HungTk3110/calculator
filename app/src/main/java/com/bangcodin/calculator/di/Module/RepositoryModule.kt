package com.bangcodin.calculator.di.Module

import com.example.demo.data.repository.Repository
import com.example.demo.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsRepository(mainRepository: RepositoryImpl) : Repository
}