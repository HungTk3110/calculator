package com.bangcodin.calculator.di.Module

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsRepository(mainRepository: RepositoryImpl) : Repository
}